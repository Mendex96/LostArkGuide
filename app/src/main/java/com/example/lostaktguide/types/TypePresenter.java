package com.example.lostaktguide.types;

import com.example.lostaktguide.app.GuideMediator;

import java.lang.ref.WeakReference;

public class TypePresenter implements TypeContract.Presenter {

    public static String TAG = TypePresenter.class.getSimpleName();

    private WeakReference<TypeContract.View> view;
    private TypeState state;
    private TypeContract.Model model;
    private GuideMediator mediator;

    public TypePresenter(GuideMediator mediator) {
        this.mediator = mediator;
       // state = mediator.getTypeState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new TypeState();

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
       /* PreviousToTypeState savedState = getStateFromPreviousScreen();
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

        // use passed state if is necessary
       /* NextToTypeState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        //view.get().onDataUpdated(state);

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


    @Override
    public void injectView(WeakReference<TypeContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(TypeContract.Model model) {
        this.model = model;
    }

}