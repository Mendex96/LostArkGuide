package com.example.lostaktguide.init;

import android.content.Context;

import java.lang.ref.WeakReference;

public interface InitContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(InitViewModel viewModel);

        void navigateToLoginScreen();

        void navigateToRegisterScreen();

        void navigateToGuestScreen();

        Context send();
    }

        interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void loginButtonClicked();
        void registerButtonClicked();
        void guestButtonClicked();



        void onResume();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}