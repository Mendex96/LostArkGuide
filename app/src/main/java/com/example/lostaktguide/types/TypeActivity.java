package com.example.lostaktguide.types;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lostaktguide.R;
import com.example.lostaktguide.data.ClassItem;
import com.example.lostaktguide.login.LoginActivity;
import com.example.lostaktguide.subclass.SubClassActivity;

public class TypeActivity
        extends AppCompatActivity implements TypeContract.View {

    public static String TAG = TypeActivity.class.getSimpleName();

    private TypeContract.Presenter presenter;

    @Override
    public void navigateToSubClassScreen() {
        Intent intent = new Intent(this, SubClassActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_list);

        TypeAdapter typeAdapter = new TypeAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassItem item = (ClassItem) view.getTag();
                presenter.selectTypeListData(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.category_list);
        recyclerView.setAdapter(typeAdapter);
        TypeScreen.configure(this);
        presenter.fetchTypeListData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }


    @Override
    public void displayTypeListData(TypeViewModel viewModel) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                //TypeAdapter.setItems(viewModel.classes);
            }

        });
    }

    @Override
    public void injectPresenter(TypeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}