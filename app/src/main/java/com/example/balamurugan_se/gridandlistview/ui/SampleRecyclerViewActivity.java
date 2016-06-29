package com.example.balamurugan_se.gridandlistview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.balamurugan_se.gridandlistview.R;
import com.example.balamurugan_se.gridandlistview.adapter.RecyclerViewMultipleRowAdapter;
import com.example.balamurugan_se.gridandlistview.model.AddressModel;
import com.example.balamurugan_se.gridandlistview.model.AgeModel;
import com.example.balamurugan_se.gridandlistview.model.MultipleRowModel;
import com.example.balamurugan_se.gridandlistview.model.NameModel;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SampleRecyclerViewActivity<T> extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private String TAG = SampleRecyclerViewActivity.class.getSimpleName();
    private BaseNetworkApi mBaseNetworkApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_recycler_view);
        initView();
        initUiValues();

    }

    private void initView() {
        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://demo0214632.mockable.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mBaseNetworkApi = retrofit.create(BaseNetworkApi.class);
            mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void initUiValues() {
        try {
            hitMultipleRows();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void initAdapterValues(MultipleRowModel multipleRowModel) {
        try {

            ArrayList<T> mArrayList = multipleRowModel.getmArrayList();

            for (int i = 0; i < mArrayList.size(); i++) {
                if (i == 0) {
                    NameModel mNameModel = (NameModel) mArrayList.get(i);
                    if (mNameModel != null) {
                        Log.d(TAG, "initAdapterValues Name model if" + mNameModel.getFirstName());
                    } else {
                        Log.d(TAG, "initAdapterValues Name model else");
                    }
                } else if (i == 1) {
                    Log.d(TAG, "initAdapterValues Age model");
                } else if (i == 2) {
                    Log.d(TAG, "initAdapterValues Address model");
                } else {
                    Log.d(TAG, "initAdapterValues else");
                }
               /* if (multipleRowModel.getmArrayList().get(i) instanceof NameModel) {
                    Log.d(TAG, "initAdapterValues Name model");
                } else if (multipleRowModel.getmArrayList().get(i) instanceof AgeModel) {
                    Log.d(TAG, "initAdapterValues Age model");
                } else if (multipleRowModel.getmArrayList().get(i) instanceof AddressModel) {
                    Log.d(TAG, "initAdapterValues Address model");
                }else {
                    Log.d(TAG, "initAdapterValues else");
                }*/
            }
            /*RecyclerViewMultipleRowAdapter recyclerViewMultipleRowAdapter = new RecyclerViewMultipleRowAdapter(this, multipleRowModel.getmArrayList());
            mRecyclerView.setAdapter(recyclerViewMultipleRowAdapter);*/
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void hitMultipleRows() {
        try {

            Call<MultipleRowModel> multipleRowModelCall = mBaseNetworkApi.getMultipleRowData();
            multipleRowModelCall.enqueue(new Callback<MultipleRowModel>() {
                @Override
                public void onResponse(Call<MultipleRowModel> call, Response<MultipleRowModel> response) {
                    Log.d(TAG, "onResponse " );
                    initAdapterValues(response.body());
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
