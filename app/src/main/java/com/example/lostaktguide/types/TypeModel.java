package com.example.lostaktguide.types;

import com.example.lostaktguide.data.RepositoryContract;

public class TypeModel implements TypeContract.Model {

    public static String TAG = TypeModel.class.getSimpleName();

    private String data;

    public TypeModel(String data) {
        this.data = data;
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void fetchTypeData(RepositoryContract.GetTypeCallback callback) {

    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}