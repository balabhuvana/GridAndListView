package com.example.balamurugan_se.gridandlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewActivity extends AppCompatActivity {

    private static final String[] items = {"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};
    private TextView mSelectedValue;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        intValues();
    }

    private void initView() {
        try {
            mSelectedValue = (TextView) findViewById(R.id.selectedValue);
            mGridView = (GridView) findViewById(R.id.gridView);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void intValues() {
        try {
            mGridView.setAdapter(new ArrayAdapter<String>(this, R.layout.row, items));
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mSelectedValue.setText(items[position]);
                }
            });
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}
