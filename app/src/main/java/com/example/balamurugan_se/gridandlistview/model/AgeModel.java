package com.example.balamurugan_se.gridandlistview.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by balamurugan_se on 6/28/2016.
 */
public class AgeModel<T> {
    @SerializedName("rowType")
    int rowType;

    private String age;

    public int getRowType() {
        return rowType;
    }

    public void setRowType(int rowType) {
        this.rowType = rowType;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
