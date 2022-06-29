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


public class GuideRepository {
    public static String TAG = GuideRepository.class.getSimpleName();


    public static final String DB_FILE = "catalog.db";
    public static final String JSON_FILE = "catalog.json";
    public static final String JSON_ROOT = "categories";

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


    private boolean loadCatalogFromJSON(String json) {
        Log.e(TAG, "loadCatalogFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
/*
        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            if (jsonArray.length() > 0) {

                final List<CategoryItem> categories = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), CategoryItem[].class)
                );

                for (CategoryItem category: categories) {
                    getCategoryDao().insertCategory(category);
                }

                for (CategoryItem category: categories) {
                    for (ProductItem product: category.item) {
                        product.categoryId = category.id;
                        getProductDao().insertProduct(product);
                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }*/

        return false;
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


}
