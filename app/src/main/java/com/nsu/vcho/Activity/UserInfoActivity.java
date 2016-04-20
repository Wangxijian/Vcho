package com.nsu.vcho.Activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.nsu.vcho.Bean.UserInfoList;
import com.nsu.vcho.Interface.CallBack;
import com.nsu.vcho.R;
import com.nsu.vcho.Utils.Util;
import com.nsu.vcho.Utils.Util_Volley;
import com.roger.catloadinglibrary.CatLoadingView;

/**
 * Created by tinyyoung on 2016/4/14.
 */
public class UserInfoActivity extends BaseActivity implements CallBack,View.OnClickListener{
    String username;
    ImageView back;
    TextView info_username, info_nickname, info_sex, info_home, info_introduction,back_user;
    CatLoadingView mView;
    Util util;
    RequestQueue queue;

    @Override
    public void setContentView() {
        setContentView(R.layout.userinfo_layout);
        mView = new CatLoadingView();
    }

    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.back);
        back_user = (TextView) findViewById(R.id.back_user);
        back_user.setOnClickListener(this);
        back.setOnClickListener(this);
        mView.show(getSupportFragmentManager(), "");
        util = Util.getInstance(this);
        queue = Util_Volley.getinstance();
        info_username = (TextView) findViewById(R.id.info_username);
        info_home = (TextView) findViewById(R.id.info_home);
        info_introduction = (TextView) findViewById(R.id.info_introduction);
        info_sex = (TextView) findViewById(R.id.info_sex);
        info_nickname = (TextView) findViewById(R.id.info_nickname);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        queue.add(util.getUserInfo(this, username));

    }

    @Override
    public void afterViewLogic() {

    }

    @Override
    public void LoginCallback(String str) {
        Log.e("msg", str);
        Gson g = new Gson();
        UserInfoList info = g.fromJson(str, UserInfoList.class);
        Log.e("msg", info.getList().toString());
        switch (info.getList().get(0).getCode()) {
            case 0:
                info_username.setText(info.getList().get(0).getUsername());
                info_home.setText(info.getList().get(0).getAddress());
                info_nickname.setText(info.getList().get(0).getNickname());
                info_introduction.setText(info.getList().get(0).getIntroduction());
                if (info.getList().get(0).getSex() == 0) {
                    info_sex.setText("男");
                } else if (info.getList().get(0).getSex() == 1) {
                    info_sex.setText("女");
                }
                mView.dismiss();
                break;
            case 1:
                Toast.makeText(this, "系统错误", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "异常", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_user:
                finish();
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
