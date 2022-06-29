package com.example.lostaktguide.types;

import android.util.Log;

import com.example.lostaktguide.data.RepositoryContract;

public class TypeModel implements TypeContract.Model {

    public static String TAG = TypeModel.class.getSimpleName();

    private RepositoryContract repository;

    public TypeModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public void fetchTypeData(
            RepositoryContract.GetTypeCallback callback) {
        Log.e(TAG, "fetchTypeListData()");

        repository.loadCatalog(
                false, new RepositoryContract.FetchClassDataCallback() {

                    @Override
                    public void onTypeDataFetched(boolean error) {
                        if(!error) {
                            repository.getTypeList(callback);
                        }
                    }
                });
    }
}