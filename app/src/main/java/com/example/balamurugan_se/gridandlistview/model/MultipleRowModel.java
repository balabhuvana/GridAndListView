package com.example.balamurugan_se.gridandlistview.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by balamurugan_se on 6/28/2016.
 */
public class MultipleRowModel<T> {
    @SerializedName("rowType")
    private int rowType;
    @SerializedName("data")
    private ArrayList<T> mArrayList;

    public int getRowType() {
        return rowType;
    }

    public void setRowType(int rowType) {
        this.rowType = rowType;
    }

    public ArrayList<T> getmArrayList() {
        return mArrayList;
    }

    public void setmArrayList(ArrayList<T> mArrayList) {
        this.mArrayList = mArrayList;
    }
}
