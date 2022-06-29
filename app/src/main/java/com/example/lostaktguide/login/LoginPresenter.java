package com.example.lostaktguide.login;

import android.util.Log;

import com.example.lostaktguide.app.GuideMediator;

import java.lang.ref.WeakReference;

public class LoginPresenter implements LoginContract.Presenter {

    public static String TAG = LoginPresenter.class.getSimpleName();

    private WeakReference<LoginContract.View> view;
    private LoginState state;
    private LoginContract.Model model;
    private GuideMediator mediator;

    public LoginPresenter(GuideMediator mediator) {
        this.mediator = mediator;
        //state = mediator.getloginState();
    }

    @Override
    public void onStart() {/*
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new loginState();

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        PreviousTologinState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/
    }

    @Override
    public void onRestart() {
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");
/*
        // use passed state if is necessary
        NextTologinState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);*/

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {



    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }
/*
    private NextTologinState getStateFromNextScreen() {
        return mediator.getNextloginScreenState();
    }

    private void passStateToNextScreen(loginToNextState state) {
        mediator.setNextloginScreenState(state);
    }

    private void passStateToPreviousScreen(loginToPreviousState state) {
        mediator.setPreviousloginScreenState(state);
    }

    private PreviousTologinState getStateFromPreviousScreen() {
        return mediator.getPreviousloginScreenState();
    }
*/
    @Override
    public void injectView(WeakReference<LoginContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(LoginContract.Model model) {
        this.model = model;
    }

}