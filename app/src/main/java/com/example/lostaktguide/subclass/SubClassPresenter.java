package com.example.lostaktguide.subclass;

import com.example.lostaktguide.app.GuideMediator;

import java.lang.ref.WeakReference;

public class SubClassPresenter implements SubClassContract.Presenter {

    public static String TAG = SubClassPresenter.class.getSimpleName();

    private WeakReference<SubClassContract.View> view;
    private SubClassState state;
    private SubClassContract.Model model;
    private GuideMediator mediator;

    public SubClassPresenter(GuideMediator mediator) {
        this.mediator = mediator;
        //state = mediator.getSubClassState();
    }

    @Override
    public void onStart() {/*
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new SubClassState();

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        PreviousToSubClassState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/
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
/*
        // use passed state if is necessary
        NextToSubClassState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);*/

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
/*
    private NextToSubClassState getStateFromNextScreen() {
        return mediator.getNextSubClassScreenState();
    }

    private void passStateToNextScreen(SubClassToNextState state) {
        mediator.setNextSubClassScreenState(state);
    }

    private void passStateToPreviousScreen(SubClassToPreviousState state) {
        mediator.setPreviousSubClassScreenState(state);
    }

    private PreviousToSubClassState getStateFromPreviousScreen() {
        return mediator.getPreviousSubClassScreenState();
    }*/

    @Override
    public void injectView(WeakReference<SubClassContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SubClassContract.Model model) {
        this.model = model;
    }

}