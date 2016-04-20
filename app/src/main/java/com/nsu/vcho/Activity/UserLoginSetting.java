package com.nsu.vcho.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nsu.vcho.R;

/**
 * Created by tinyyoung on 2016/4/14.
 */
public class UserLoginSetting extends BaseActivity implements View.OnClickListener{
    LinearLayout adduser_lin;
    ImageView setting_back_im;
    TextView setting_back_tv;
    @Override
    public void setContentView() {
        setContentView(R.layout.userloginsetting_layout);
    }

    @Override
    public void initView() {
        adduser_lin = (LinearLayout) findViewById(R.id.adduser_lin);
        setting_back_im = (ImageView) findViewById(R.id.setting_back_im);
        setting_back_tv = (TextView) findViewById(R.id.setting_back_tv);
        setting_back_tv.setOnClickListener(this);
        setting_back_im.setOnClickListener(this);
        adduser_lin.setOnClickListener(this);
    }

    @Override
    public void afterViewLogic() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.adduser_lin:
                Intent intent = new Intent(UserLoginSetting.this, LoginActivity.class);
                intent.putExtra("userInfo","aaa");
                startActivity(intent);
                UserLoginSetting.this.finish();
                break;
            case R.id.setting_back_im:
                finish();
                break;
            case R.id.setting_back_tv:
                finish();
                break;
        }
    }
}
