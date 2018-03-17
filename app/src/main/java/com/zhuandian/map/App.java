package com.zhuandian.map;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * desc :
 * author：xiedong
 * data：2018/3/17
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "Your Application ID");
    }
}
