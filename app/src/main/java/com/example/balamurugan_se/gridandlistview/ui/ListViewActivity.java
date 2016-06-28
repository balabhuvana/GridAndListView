package com.example.balamurugan_se.gridandlistview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.balamurugan_se.gridandlistview.R;
import com.example.balamurugan_se.gridandlistview.adapter.ListViewAdapter;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private static final String[] items = {"Anand", "Akila", "Anand",
            "Bala", "Balaji", "Balaram",
            "Chitra", "Cheeta", "Chinna", "Chilla", "Devi",
            "Deva", "Divakar", "Dheena", "Dinesh", "Elango",
            "Elavarasi", "Elavarasan", "Elangovan", "Easy", "Fathima",
            "Franklin", "France", "Fernados", "Fathima", "Function"};
    private AutoCompleteTextView mAutoCompleteTextView;
    private ListView mListView;
    private ListViewAdapter mListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initView();
        intValues();
    }

    private void initView() {
        try {
            mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.mAutoCompleteTextView);
            mListView = (ListView) findViewById(R.id.listView);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void intValues() {
        try {


            ArrayList mArrayList = new ArrayList();
            mArrayList.add("Anand");
            mArrayList.add("Akila");
            mArrayList.add("Bala");
            mArrayList.add("Balaji");
            mArrayList.add("Balaram");
            mArrayList.add("Chitra");
            mArrayList.add("Cheeta");
            mArrayList.add("Chinna");
            mArrayList.add("Chilla");
            mArrayList.add("Devi");
            mArrayList.add("Deva");
            mArrayList.add("Divakar");
            mArrayList.add("Dheena");
            mArrayList.add("Dinesh");
            mArrayList.add("Elango");
            mListViewAdapter = new ListViewAdapter(this, mArrayList);
            mListView.setAdapter(mListViewAdapter);

            mAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (count < before) {
                        // We're deleting char so we need to reset the adapter data
                        mListViewAdapter.resetData();
                    }
                    mListViewAdapter.getFilter().filter(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


}
