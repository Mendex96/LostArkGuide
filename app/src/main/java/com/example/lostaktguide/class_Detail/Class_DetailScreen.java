package com.example.lostaktguide.class_Detail;

import androidx.fragment.app.FragmentActivity;

import com.example.lostaktguide.R;
import com.example.lostaktguide.app.GuideMediator;

import java.lang.ref.WeakReference;

public class Class_DetailScreen {

    public static void configure(Class_DetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        GuideMediator mediator = GuideMediator.getInstance();

        Class_DetailContract.Presenter presenter = new Class_DetailPresenter(mediator);
        Class_DetailContract.Model model = new Class_DetailModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}