package com.example.lostaktguide.init;

import com.example.lostaktguide.app.GuideMediator;

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
    public void injectView(WeakReference<InitContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(InitContract.Model model) {
        this.model = model;
    }

}