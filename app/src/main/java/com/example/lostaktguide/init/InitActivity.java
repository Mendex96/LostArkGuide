package com.example.lostaktguide.init;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.lostaktguide.R;


import androidx.appcompat.app.AppCompatActivity;

public class InitActivity
        extends AppCompatActivity implements InitContract.View {

    public static String TAG = InitActivity.class.getSimpleName();

    private InitContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        // do the setup
        InitScreen.configure(this);

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
    public void onDataUpdated(InitViewModel viewModel) {

    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, InitActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(InitContract.Presenter presenter) {
        this.presenter = presenter;
    }
}