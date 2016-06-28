package com.example.balamurugan_se.gridandlistview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.balamurugan_se.gridandlistview.R;
import com.example.balamurugan_se.gridandlistview.model.MultipleRowModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SampleRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private String TAG = SampleRecyclerViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_recycler_view);
        initView();
        initValues();

    }

    private void initView() {
        try {
            mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void initValues() {
        try {
            hitFruits();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void hitFruits() {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://demo0214632.mockable.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            BaseNetworkApi mBaseNetworkApi = retrofit.create(BaseNetworkApi.class);

            Call<MultipleRowModel> multipleRowModelCall = mBaseNetworkApi.getMultipleRowData();
            multipleRowModelCall.enqueue(new Callback<MultipleRowModel>() {
                @Override
                public void onResponse(Call<MultipleRowModel> call, Response<MultipleRowModel> response) {
                    MultipleRowModel multipleRowModel = (MultipleRowModel) call;
                    Log.d(TAG, "onResponse ");
                }

                @Override
                public void onFailure(Call<MultipleRowModel> call, Throwable t) {
                    Log.d(TAG, "onFailure " + t.getMessage());
                }
            });

        } catch (Exception exp) {
            exp.printStackTrace();
        }


    }
}
