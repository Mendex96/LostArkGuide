package com.example.lostaktguide.types;

import com.example.lostaktguide.data.ClassItem;
import com.example.lostaktguide.data.RepositoryContract;

import java.lang.ref.WeakReference;

public interface TypeContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayTypeListData(TypeViewModel viewModel);

        void navigateToSubClassScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void selectTypeListData(ClassItem item);
        void fetchTypeListData();

        void onResume();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {

        void fetchTypeData(
                RepositoryContract.GetTypeCallback callback);
    }

}