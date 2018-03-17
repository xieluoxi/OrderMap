package com.zhuandian.map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

public class MapActivity extends AppCompatActivity {
    private MapView mMapView = null;
    private BitmapDescriptor mCurrentMarker;
    private int accuracyCircleFillColor;
    private int accuracyCircleStrokeColor;
    private BaiduMap mBaiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_map);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        mCurrentMarker = BitmapDescriptorFactory.fromResource(R.drawable.car);
        accuracyCircleFillColor = 0xAAFFFF88;//自定义精度圈填充颜色
        accuracyCircleStrokeColor = 0xAA00FF00;//自定义精度圈边框颜色
        mMapView.getMap().setMyLocationConfiguration(new MyLocationConfiguration(
                MyLocationConfiguration.LocationMode.FOLLOWING, true, mCurrentMarker,
                accuracyCircleFillColor, accuracyCircleStrokeColor));


        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);


        //定义Maker坐标点

        LatLng point = new LatLng(39.963175, 116.400244);

        LatLng point1 = new LatLng(40.05, 116.200244);

        //构建Marker图标

        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.car);

       //构建MarkerOption，用于在地图上添加Marker

        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);

        OverlayOptions option1 = new MarkerOptions()
                .position(point1)
                .icon(bitmap);

       //在地图上添加Marker，并显示

        mBaiduMap.addOverlay(option);
        mBaiduMap.addOverlay(option1);
        mBaiduMap.addOverlay(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
