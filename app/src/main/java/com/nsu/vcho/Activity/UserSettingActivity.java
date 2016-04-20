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
public class UserSettingActivity extends BaseActivity implements View.OnClickListener {
    LinearLayout user_lin;
    TextView back_user;
    ImageView back;
    @Override
    public void setContentView() {
        setContentView(R.layout.usersetting_layout);
    }

    @Override
    public void initView() {
        user_lin = (LinearLayout) findViewById(R.id.user_lin);
        user_lin.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back);
        back_user = (TextView) findViewById(R.id.back_user);
        back_user.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void afterViewLogic() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_lin:
                Intent intent = new Intent(UserSettingActivity.this, UserLoginSetting.class);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.back_user:
                finish();
                break;
        }
    }
}
