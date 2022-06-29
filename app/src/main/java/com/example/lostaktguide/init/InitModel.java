package com.example.lostaktguide.init;

import android.util.Log;

import com.example.lostaktguide.data.GuideRepository;
import com.example.lostaktguide.data.RepositoryContract;

public class InitModel implements InitContract.Model {

    public static String TAG = InitModel.class.getSimpleName();

    private GuideRepository repository;

    public InitModel(GuideRepository repository) {
        this.repository = repository;
    }


    @Override
    public void fetchInitListData(RepositoryContract.GetUserListCallback callback) {
        Log.e(TAG, "fetchUserListData()");
        repository.loadUser(
                true, new RepositoryContract.FetchUserDataCallback() {
                    @Override
                    public void onUserDataFetched(boolean error) {
                        if (!error){
                            repository.getUserList(callback);
                        }
                    }
                }
        );


    }
}