package com.example.lostaktguide.login;

import androidx.fragment.app.FragmentActivity;

import com.example.lostaktguide.R;
import com.example.lostaktguide.app.GuideMediator;
import com.example.lostaktguide.data.GuideRepository;
import com.example.lostaktguide.data.RepositoryContract;

import java.lang.ref.WeakReference;

public class LoginScreen {

    public static void configure(LoginContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);


        GuideMediator mediator = GuideMediator.getInstance();
        RepositoryContract repository = GuideRepository.getInstance(context.get());

        LoginContract.Presenter presenter = new LoginPresenter(mediator);
        LoginContract.Model model = new LoginModel();
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}