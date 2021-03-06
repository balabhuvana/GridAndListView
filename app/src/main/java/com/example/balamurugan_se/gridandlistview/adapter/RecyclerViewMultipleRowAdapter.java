package com.example.balamurugan_se.gridandlistview.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.balamurugan_se.gridandlistview.R;
import com.example.balamurugan_se.gridandlistview.model.AddressModel;
import com.example.balamurugan_se.gridandlistview.model.AgeModel;
import com.example.balamurugan_se.gridandlistview.model.NameModel;
import com.example.balamurugan_se.gridandlistview.ui.MultipleViewHolder;

import java.util.ArrayList;

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
        if (mArrayList.get(position) instanceof NameModel) {
            NameModel mNameModel = ((NameModel) mArrayList.get(position));
            holder.mFirstName.setText(mNameModel.getFirstName());
            holder.mLastName.setText(mNameModel.getLastName());
            holder.mPetName.setText(mNameModel.getPetName());
        } else if (mArrayList.get(position) instanceof AgeModel) {
            AgeModel mAgeModel = ((AgeModel) mArrayList.get(position));
            holder.mAge.setText(mAgeModel.getAge());
        } else if (mArrayList.get(position) instanceof AddressModel) {
            AddressModel mAddressModel = ((AddressModel) mArrayList.get(position));
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

        if (mArrayList.get(position) instanceof NameModel) {
            Toast.makeText(mActivity, "namemodel", Toast.LENGTH_SHORT).show();
            return ((NameModel) mArrayList.get(position)).getRowType();
        } else if (mArrayList.get(position) instanceof AgeModel) {
            Toast.makeText(mActivity, "namemodel", Toast.LENGTH_SHORT).show();
            return ((AgeModel) mArrayList.get(position)).getRowType();
        } else if (mArrayList.get(position) instanceof AddressModel) {
            Toast.makeText(mActivity, "namemodel", Toast.LENGTH_SHORT).show();
            return ((AddressModel) mArrayList.get(position)).getRowType();
        } else {
            Toast.makeText(mActivity, "else " + position, Toast.LENGTH_SHORT).show();
        }
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
