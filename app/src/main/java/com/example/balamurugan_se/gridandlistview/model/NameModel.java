package com.example.balamurugan_se.gridandlistview.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConverter;
import org.parceler.ParcelPropertyConverter;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels;

/**
 * Created by balamurugan_se on 6/28/2016.
 */
@Parcel
public class NameModel<T> {
    @SerializedName("rowType")
    int rowType;

    public int getRowType() {
        return rowType;
    }

    public void setRowType(int rowType) {
        this.rowType = rowType;
    }

    @ParcelPropertyConverter(ParcelWrapperConverter.class)
    private String firstName;
    @ParcelPropertyConverter(ParcelWrapperConverter.class)
    private String lastName;
    @ParcelPropertyConverter(ParcelWrapperConverter.class)
    private String petName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
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
