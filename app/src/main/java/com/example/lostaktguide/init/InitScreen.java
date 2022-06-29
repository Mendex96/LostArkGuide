package com.example.lostaktguide.init;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;
import com.example.lostaktguide.R;
import com.example.lostaktguide.app.GuideMediator;
import com.example.lostaktguide.data.GuideRepository;

public class InitScreen {

    public static void configure(InitContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        GuideMediator mediator = GuideMediator.getInstance();
        GuideRepository guideRepository = GuideRepository.getInstance(context.get());

        InitContract.Presenter presenter = new InitPresenter(mediator);
        InitContract.Model model = new InitModel(guideRepository);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}