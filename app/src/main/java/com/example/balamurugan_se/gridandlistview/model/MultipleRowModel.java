package com.example.balamurugan_se.gridandlistview.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConverter;
import org.parceler.ParcelPropertyConverter;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by balamurugan_se on 6/28/2016.
 */
@Parcel
public class MultipleRowModel<T> {


    @ParcelPropertyConverter(ParcelWrapperConverter.class)
    @SerializedName("data")
    private ArrayList<T> mArrayList;

    public ArrayList<T> getmArrayList() {
        return mArrayList;
    }

    public void setmArrayList(ArrayList<T> mArrayList) {
        this.mArrayList = mArrayList;
    }

    public static class ParcelWrapperConverter implements ParcelConverter {

        @Override
        public void toParcel(Object input, android.os.Parcel parcel) {
            parcel.writeParcelable(Parcels.wrap(input), 0);
        }

        @Override
        public Object fromParcel(android.os.Parcel parcel) {
            return ((ParcelWrapper) parcel.readParcelable(ParcelWrapperConverter.class.getClassLoader())).getParcel();
        }
    }
}
