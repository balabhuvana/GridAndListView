package com.example.balamurugan_se.gridandlistview.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.balamurugan_se.gridandlistview.R;

/**
 * Created by balamurugan_se on 6/28/2016.
 */

public class MultipleViewHolder extends RecyclerView.ViewHolder {
    public TextView mFirstName;
    public TextView mLastName;
    public TextView mPetName;
    public TextView mAge;
    public TextView mDoorNo;
    public TextView mStreetName;
    public TextView mCityName;
    public TextView mStateName;

    public MultipleViewHolder(View view, int type) {
        super(view);
        if (type == 0) {
            mFirstName = (TextView) view.findViewById(R.id.firstName);
            mLastName = (TextView) view.findViewById(R.id.lastName);
            mPetName = (TextView) view.findViewById(R.id.petName);
        } else if (type == 1) {
            mAge = (TextView) view.findViewById(R.id.age);
        } else if (type == 2) {
            mDoorNo = (TextView) view.findViewById(R.id.doorNo);
            mStreetName = (TextView) view.findViewById(R.id.streetName);
            mCityName = (TextView) view.findViewById(R.id.city);
            mStateName = (TextView) view.findViewById(R.id.state);
        }
    }

}

