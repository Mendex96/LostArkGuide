package com.example.lostaktguide.init;

import android.app.Activity;
import android.widget.Toast;

import com.example.lostaktguide.app.GuideMediator;
import com.example.lostaktguide.app.InitToTypeState;
import com.example.lostaktguide.data.InitItem;
import com.example.lostaktguide.init.InitActivity;


import java.lang.ref.WeakReference;

public class InitPresenter implements InitContract.Presenter {

    public static String TAG = InitPresenter.class.getSimpleName();

    private WeakReference<InitContract.View> view;
    private InitState state;
    private InitContract.Model model;
    private GuideMediator mediator;

    public InitPresenter(GuideMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onRestart() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    @Override
    public void loginButtonClicked() {
        view.get().navigateToLoginScreen();
    }

    @Override
    public void registerButtonClicked() {
        view.get().navigateToRegisterScreen();
    }

    @Override
    public void guestButtonClicked() {
        InitToTypeState item = new InitToTypeState(false);
        passDataToTypeScreen(item);
        view.get().navigateToGuestScreen();

    }

    private void passDataToTypeScreen(InitToTypeState item) {
        mediator.setInit_State(item);
    }

    @Override
    public void injectView(WeakReference<InitContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(InitContract.Model model) {
        this.model = model;
    }

}