package com.example.lostaktguide.types;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lostaktguide.R;
import com.example.lostaktguide.data.ClassItem;

public class TypeActivity
        extends AppCompatActivity implements TypeContract.View {

    public static String TAG = TypeActivity.class.getSimpleName();

    private TypeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_list);
        getSupportActionBar().setTitle(R.string.app_name);


        listAdapter = new TypeA(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ClassItem item = (ClassItem) Item) view.getTag();
                presenter.selectCategoryListData(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.category_list);
        recyclerView.setAdapter(listAdapter);

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
    public void onDataUpdated(TypeViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
       // ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, TypeActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(TypeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}