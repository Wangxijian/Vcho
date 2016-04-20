package com.nsu.vcho.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Mark-1 on 2016/4/13.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        initView();
        afterViewLogic();
    }
    public abstract void setContentView();
    public abstract void initView();
    public abstract void afterViewLogic();

    public void startActivity(Class<?> clazz,boolean finish){
        Intent i = new Intent(this,clazz);
        startActivity(i);
        if (finish){
            this.finish();
        }
    }
}