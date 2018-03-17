package com.zhuandian.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.et_code)
    EditText etCode;
    private BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initMenuLayout();
    }

    private void initMenuLayout() {
        LinearLayout shareView = (LinearLayout) findViewById(R.id.share_view);
        //获取BottomSheetBehavior
        sheetBehavior = BottomSheetBehavior.from(shareView);

        //设置折叠时的高度
        //sheetBehavior.setPeekHeight(BottomSheetBehavior.PEEK_HEIGHT_AUTO);

        //监听BottomSheetBehavior 状态的变化
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        //下滑的时候是否可以隐藏
        sheetBehavior.setHideable(true);
    }

    @OnClick({R.id.tv_menu, R.id.ll_order, R.id.btn_search, R.id.ll_help, R.id.ll_map, R.id.ll_delivery, R.id.ll_feedback, R.id.ll_reward})
    public void onViewClicked(View view) {
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        switch (view.getId()) {
            case R.id.tv_menu:
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
                break;
            case R.id.ll_order:
                startActivity(new Intent(this, SearchOrderActivity.class));
                break;
            case R.id.ll_help:
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case R.id.ll_map:
                startActivity(new Intent(this, MapActivity.class));
                break;
            case R.id.ll_delivery:
                startActivity(new Intent(this, MapActivity.class));
                break;
            case R.id.ll_feedback:
                startActivity(new Intent(this, FeedBackActivity.class));
                break;
            case R.id.ll_reward:
                startActivity(new Intent(this, AwardActivity.class));
                break;
            case R.id.btn_search:
                if (etCode.getText().toString().length() < 3) {
                    Toast.makeText(this, "Please enter the correct zip code....", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, MapActivity.class));
                }
                break;
        }
    }


}
