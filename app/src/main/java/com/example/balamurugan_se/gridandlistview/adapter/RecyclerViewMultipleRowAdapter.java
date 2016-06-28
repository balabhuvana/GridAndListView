package com.example.balamurugan_se.gridandlistview.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.example.balamurugan_se.gridandlistview.R;
import com.example.balamurugan_se.gridandlistview.model.AddressModel;
import com.example.balamurugan_se.gridandlistview.model.AgeModel;
import com.example.balamurugan_se.gridandlistview.model.MultipleRowModel;
import com.example.balamurugan_se.gridandlistview.model.NameModel;
import com.example.balamurugan_se.gridandlistview.ui.MultipleViewHolder;

/**
 * Created by balamurugan_se on 6/28/2016.
 */
public class RecyclerViewMultipleRowAdapter<T> extends RecyclerView.Adapter<MultipleViewHolder> {

    private Activity mActivity;
    private ArrayList<T> mArrayList;
    private LayoutInflater mInflater;


    public RecyclerViewMultipleRowAdapter(Activity oActivity, ArrayList oArrayList) {
        this.mActivity = oActivity;
        this.mArrayList = oArrayList;
        mInflater = oActivity.getLayoutInflater();
    }

    @Override
    public MultipleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = null;
        if (viewType == 0) {
            mView = mInflater.inflate(R.layout.row_name, parent, false);
        } else if (viewType == 1) {
            mView = mInflater.inflate(R.layout.row_age, parent, false);
        } else if (viewType == 2) {
            mView = mInflater.inflate(R.layout.row_address, parent, false);
        }
        return new MultipleViewHolder(mView, viewType);
    }

    @Override
    public void onBindViewHolder(MultipleViewHolder holder, int position) {
        if (((MultipleRowModel) mArrayList.get(position)).getRowType() == 0) {
            ArrayList nameList = ((MultipleRowModel) mArrayList.get(position)).getmArrayList();
            NameModel mNameModel = (NameModel) nameList.get(0);
            holder.mFirstName.setText(mNameModel.getFirstName());
            holder.mLastName.setText(mNameModel.getLastName());
            holder.mPetName.setText(mNameModel.getPetName());
        } else if (((MultipleRowModel) mArrayList.get(position)).getRowType() == 1) {
            ArrayList ageList = ((MultipleRowModel) mArrayList.get(position)).getmArrayList();
            AgeModel mAgeModel = (AgeModel) ageList.get(0);
            holder.mAge.setText(mAgeModel.getAge());
        } else if (((MultipleRowModel) mArrayList.get(position)).getRowType() == 2) {
            ArrayList addressList = ((MultipleRowModel) mArrayList.get(position)).getmArrayList();
            AddressModel mAddressModel = (AddressModel) addressList.get(0);
            holder.mDoorNo.setText(mAddressModel.getDoorNo());
            holder.mStreetName.setText(mAddressModel.getStreetName());
            holder.mCityName.setText(mAddressModel.getCity());
            holder.mStateName.setText(mAddressModel.getState());
        }
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        MultipleRowModel multipleRowModel = (MultipleRowModel) mArrayList.get(position);

        if (multipleRowModel != null) {
            return multipleRowModel.getRowType();
        }
        return super.getItemViewType(position);
    }
}
