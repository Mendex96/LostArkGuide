package com.example.lostaktguide.types;

import androidx.fragment.app.FragmentActivity;

import com.example.lostaktguide.R;
import com.example.lostaktguide.app.GuideMediator;
import com.example.lostaktguide.data.GuideRepository;

import java.lang.ref.WeakReference;

public class TypeScreen {

    public static void configure(TypeContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        GuideMediator mediator = GuideMediator.getInstance();
        GuideRepository repository = GuideRepository.getInstance(context.get());
        TypeContract.Presenter presenter = new TypePresenter(mediator);
        TypeContract.Model model = new TypeModel(repository);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}