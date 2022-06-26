package com.example.lostaktguide.class_Detail;

import com.example.lostaktguide.app.GuideMediator;

import java.lang.ref.WeakReference;

public class Class_DetailPresenter implements Class_DetailContract.Presenter {

    public static String TAG = Class_DetailPresenter.class.getSimpleName();

    private WeakReference<Class_DetailContract.View> view;
    private Class_DetailState state;
    private Class_DetailContract.Model model;
    private GuideMediator mediator;

    public Class_DetailPresenter(GuideMediator mediator) {
        this.mediator = mediator;
        state = mediator.getClass_DetailState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new Class_DetailState();

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        PreviousToClass_DetailState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
        NextToClass_DetailState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    private NextToClass_DetailState getStateFromNextScreen() {
        return mediator.getNextClass_DetailScreenState();
    }

    private void passStateToNextScreen(Class_DetailToNextState state) {
        mediator.setNextClass_DetailScreenState(state);
    }

    private void passStateToPreviousScreen(Class_DetailToPreviousState state) {
        mediator.setPreviousClass_DetailScreenState(state);
    }

    private PreviousToClass_DetailState getStateFromPreviousScreen() {
        return mediator.getPreviousClass_DetailScreenState();
    }

    @Override
    public void injectView(WeakReference<Class_DetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Class_DetailContract.Model model) {
        this.model = model;
    }

}