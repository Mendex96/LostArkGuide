package com.example.lostaktguide.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import com.example.lostaktguide.database.GuideDatabase;
import com.example.lostaktguide.database.ClassDao;
import com.example.lostaktguide.database.FavoriteDao;
import com.example.lostaktguide.database.Sub_ClassDao;
import com.example.lostaktguide.database.UserDao;



public class GuideRepository  implements RepositoryContract{
    public static String TAG = GuideRepository.class.getSimpleName();


    public static final String DB_FILE = "catalog.db";
    public static final String JSON_FILE = "catalog.json";
    public static final String JSON_ROOT = "class";
    public static final String JSON_ROOT2 = "user";

    private static GuideRepository INSTANCE;

    private GuideDatabase database;
    private Context context;

    public static GuideRepository getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new GuideRepository(context);
        }

        return INSTANCE;
    }

    private GuideRepository(Context context) {
        this.context = context;

        database = Room.databaseBuilder(
                context, GuideDatabase.class, DB_FILE
        ).build();

    }

    @Override
    public void loadCatalog(
            final boolean clearFirst, final FetchClassDataCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(clearFirst) {
                    database.clearAllTables();
                }

                boolean error = false;
                if(getClassDao().loadClasses().size() == 0 ) {
                    error = !loadCatalogFromJSON(loadJSONFromAsset());
                }

                if(callback != null) {
                    callback.onTypeDataFetched(error);
                }
            }
        });

    }

    @Override
    public void getTypeList(final GetTypeCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setClassList(getClassDao().loadClasses());
                }
            }
        });
    }


    private boolean loadCatalogFromJSON(String json) {
        Log.e(TAG, "loadCatalogFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            if (jsonArray.length() > 0) {

                final List<ClassItem> categories = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), ClassItem[].class)
                );

                for (ClassItem category: categories) {
                    getClassDao().insertCategory(category);

                }

                for (ClassItem category: categories) {
                    for (SubClassItem subClass: category.subClass) {
                        subClass.class_id = category.id_class;
                        getSubClassDao().insertProduct(subClass);
                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private boolean loadUserFromJSON(String json) {
        Log.e(TAG, "loadUserFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT2);

            if (jsonArray.length() > 0) {

                final List<UserItem> users = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), UserItem[].class)
                );

                for (UserItem user: users) {
                    getUserDao().insertUser(user);
                }
                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }
    private ClassDao getClassDao() {
        return database.ClassDao();
    }
    private Sub_ClassDao getSubClassDao() {
        return database.Sub_ClassDao();
    }

    private FavoriteDao getFavoriteDao() {
        return database.FavoriteDao();
    }

    private UserDao getUserDao() {
        return database.UserDao();
    }


    private String loadJSONFromAsset() {
        //Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }


    @Override
    public void loadUser(boolean clearFirst, FetchUserDataCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(clearFirst) {
                    database.clearAllTables();
                }

                boolean error = false;
                if(getUserDao().loadUsers().size() == 0 ) {
                    error = !loadUserFromJSON(loadJSONFromAsset());
                }

                if(callback != null) {
                    callback.onUserDataFetched(error);
                }
            }
        });
    }

    @Override
    public void getUserList(GetUserListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setUserList(getUserDao().loadUsers());
                }
            }
        });
    }
}
