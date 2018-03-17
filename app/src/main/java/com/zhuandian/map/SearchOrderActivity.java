package com.zhuandian.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_order);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_search_order)
    public void onViewClicked() {
        Toast.makeText(this, "The order not found for your search.", Toast.LENGTH_SHORT).show();
    }
}
