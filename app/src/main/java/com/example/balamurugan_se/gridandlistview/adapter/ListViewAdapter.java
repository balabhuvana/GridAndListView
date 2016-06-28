package com.example.balamurugan_se.gridandlistview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.balamurugan_se.gridandlistview.R;

import java.util.ArrayList;

/**
 * Created by balamurugan_se on 6/27/2016.
 */
public class ListViewAdapter extends BaseAdapter implements Filterable {

    private Activity mActivity;
    private ArrayList<String> mOrginalArrayList, mArrayList;
    private LayoutInflater mInflater;
    private ViewHolder mViewHolder;
    private SampleFilter mSampleFilter;


    @Override
    public Filter getFilter() {
        if (mSampleFilter == null) {
            mSampleFilter = new SampleFilter();
        }
        return mSampleFilter;
    }

    public class ViewHolder {
        private TextView mTextView;
        private ImageView mImageView;
    }

    public ListViewAdapter(Activity oActivity, ArrayList<String> oArrayList) {
        mActivity = oActivity;
        mOrginalArrayList = oArrayList;
        mArrayList = oArrayList;
        mInflater = oActivity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = (View) mInflater.inflate(R.layout.row, null);
            mViewHolder.mTextView = (TextView) convertView.findViewById(R.id.textView);
            mViewHolder.mImageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
            if (mArrayList.get(position).toString().trim().length() > 4) {
                mViewHolder.mImageView.setBackground(mActivity.getResources().getDrawable(R.mipmap.ic_wright));
            }else {
                mViewHolder.mImageView.setBackground(mActivity.getResources().getDrawable(R.mipmap.ic_close));
            }
            mViewHolder.mTextView.setText(mArrayList.get(position));
        }
        return convertView;
    }

    public void resetData() {
        mArrayList = mOrginalArrayList;
    }

    private class SampleFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null && constraint.length() == 0) {
                results.values = mOrginalArrayList;
                results.count = mOrginalArrayList.size();
            } else {
                ArrayList<String> mSampleArrayList = new ArrayList<>();
                for (String str : mOrginalArrayList) {
                    if (str.toUpperCase().startsWith(constraint.toString().toUpperCase())) {
                        mSampleArrayList.add(str);
                    }
                }
                results.values = mSampleArrayList;
                results.count = mSampleArrayList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            if (results.count == 0) {
                notifyDataSetInvalidated();
            } else {
                mArrayList = (ArrayList<String>) results.values;
                notifyDataSetChanged();
            }
        }

    }
}
