package com.example.lostaktguide.subclass;

import androidx.fragment.app.FragmentActivity;

import com.example.lostaktguide.R;
import com.example.lostaktguide.app.GuideMediator;

import java.lang.ref.WeakReference;

public class SubClassScreen {

    public static void configure(SubClassContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        GuideMediator mediator = GuideMediator.getInstance();

        SubClassContract.Presenter presenter = new SubClassPresenter(mediator);
        SubClassContract.Model model = new SubClassModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}