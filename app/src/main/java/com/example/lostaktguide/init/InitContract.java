package com.example.lostaktguide.init;

import android.content.Context;

import com.example.lostaktguide.data.RepositoryContract;

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
       void fetchInitListData(
                 RepositoryContract.GetUserListCallback callback);
    }

}