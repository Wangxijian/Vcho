package com.nsu.vcho.Application;

import android.app.Application;

import com.nsu.vcho.Utils.Util_Volley;

/**
 * Created by Mark-1 on 2016/4/12.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Util_Volley.initialze(getApplicationContext());
    }
}
