package com.nsu.vcho.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.nsu.vcho.R;

public class LaunchActivity extends BaseActivity {

    private boolean isFirstIn;
    private static final int GoLogin = 1001;
    private static final int GoGuide = 1002;
    private static final int GoLoginWithInfo = 1003;
    private static final int TIME = 2000;
    private  String username;


    @Override
    public void setContentView() {
        setContentView(R.layout.activity_launch);
        Log.e("TAG","Launch");
    }

    @Override
    public void initView() {

    }

    @Override
    public void afterViewLogic() {
        new Thread() {
            @Override
            public void run() {
                Log.e("TAG","Thread run");
                SharedPreferences preference = getSharedPreferences("First", MODE_PRIVATE);
                isFirstIn = preference.getBoolean("isFirstIn", true);
                if (!isFirstIn) {
                    String info = preference.getString("Info",null);
                    if (info==null){

                    handler.sendEmptyMessageDelayed(GoLogin, TIME);
                    }else {
                    username = info;
                        handler.sendEmptyMessageDelayed(GoLoginWithInfo, TIME);
                    }
                } else {
                    handler.sendEmptyMessage(GoGuide);
                    SharedPreferences.Editor editor = preference.edit();
                    editor.putBoolean("isFirstIn", false);
                    editor.apply();
                }
            }
        }.run();
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GoLogin:
                    Intent i1 = new Intent(LaunchActivity.this,LoginActivity.class);
                    i1.putExtra("userInfo","aaa");
                    startActivity(i1);
                    break;
                case GoGuide:
                    startActivity(GuideActivity.class, true);
                    Log.e("TAG","jump Guide");
                    break;
                case GoLoginWithInfo:
                    Intent i = new Intent(LaunchActivity.this,LoginActivity.class);
                    i.putExtra("userInfo",username);
                    startActivity(i);
                    finish();
                    break;
            }
        }
    };
}

