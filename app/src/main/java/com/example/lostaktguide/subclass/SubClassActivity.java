package com.example.lostaktguide.subclass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lostaktguide.R;

public class SubClassActivity
        extends AppCompatActivity implements SubClassContract.View {

    public static String TAG = SubClassActivity.class.getSimpleName();

    private SubClassContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subclass_list);
        getSupportActionBar().setTitle(R.string.app_name);


        // do the setup
        SubClassScreen.configure(this);

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
    public void onDataUpdated(SubClassViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, SubClassActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(SubClassContract.Presenter presenter) {
        this.presenter = presenter;
    }
}