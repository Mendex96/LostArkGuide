package com.example.lostaktguide.init;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.lostaktguide.R;
import com.example.lostaktguide.login.LoginActivity;
import com.example.lostaktguide.register.RegisterActivity;


import androidx.appcompat.app.AppCompatActivity;

public class InitActivity
        extends AppCompatActivity implements InitContract.View {

    public static String TAG = InitActivity.class.getSimpleName();
    Button  loginButton, registerButton, guestButton;
    private InitContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        guestButton = findViewById(R.id.guest_button);

        loginButton.setOnClickListener(view -> presenter.loginButtonClicked());
        registerButton.setOnClickListener(view -> presenter.registerButtonClicked());
        guestButton.setOnClickListener(view -> presenter.guestButtonClicked());



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
    public void navigateToLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToRegisterScreen() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToGuestScreen() {

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
    public void injectPresenter(InitContract.Presenter presenter) {
        this.presenter = presenter;
    }


}