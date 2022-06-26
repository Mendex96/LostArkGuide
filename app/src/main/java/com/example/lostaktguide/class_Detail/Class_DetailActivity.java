package com.example.lostaktguide.class_Detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lostaktguide.R;

public class Class_DetailActivity
        extends AppCompatActivity implements Class_DetailContract.View {

    public static String TAG = Class_DetailActivity.class.getSimpleName();

    private Class_DetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        getSupportActionBar().setTitle(R.string.app_name);


        // do the setup
        Class_DetailScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(Class_DetailViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Class_DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Class_DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}