package com.example.lostaktguide.types;

import com.example.lostaktguide.app.GuideMediator;
import com.example.lostaktguide.data.ClassItem;
import com.example.lostaktguide.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.List;

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
    }

    @Override
    public void onRestart() {
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

    @Override
    public void selectTypeListData(ClassItem item) {
        passDataToSubClassScreen(item);
        view.get().navigateToSubClassScreen();
    }

    private void passDataToSubClassScreen(ClassItem item) {
        mediator.setClassItem(item);
    }

    @Override
    public void fetchTypeListData() {
        model.fetchTypeData( new RepositoryContract.GetTypeCallback() {
            @Override
            public void setClassList(List<ClassItem> classes) {
                state.classes = classes;
                view.get().displayTypeListData(state);
            }
        });

    }

}