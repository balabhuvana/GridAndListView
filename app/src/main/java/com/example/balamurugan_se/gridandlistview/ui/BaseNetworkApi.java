package com.example.balamurugan_se.gridandlistview.ui;

import com.example.balamurugan_se.gridandlistview.model.MultipleRowModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by balamurugan_se on 6/9/2016.
 */
public interface BaseNetworkApi {

    @GET("/multiplerows")
    Call<MultipleRowModel> getMultipleRowData();

}
