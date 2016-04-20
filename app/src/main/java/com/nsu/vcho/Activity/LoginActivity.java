package com.nsu.vcho.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.nsu.vcho.Bean.LoginInfo;
import com.nsu.vcho.Interface.CallBack;
import com.nsu.vcho.R;
import com.nsu.vcho.Utils.Util;
import com.nsu.vcho.Utils.Util_Volley;

public class LoginActivity extends BaseActivity implements View.OnClickListener, CallBack {

    RequestQueue queue;
    EditText username, password;
    Button login;
    String name, psw;
    Util util;
    StringRequest s;
    CheckBox pwdRemember;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        pwdRemember = (CheckBox) findViewById(R.id.pwdRemember);
        login.setOnClickListener(this);
        Intent i = getIntent();
        i.getStringExtra("userInfo");
        String info = i.getStringExtra("userInfo");
        if (!info.equals("aaa")) {
            String s[] = info.split(",");
            username.setText(s[0]);
            password.setText(s[1]);
            pwdRemember.setChecked(true);
        }
    }

    @Override
    public void afterViewLogic() {
        util = Util.getInstance(this);
        queue = Util_Volley.getinstance();

    }

    @Override
    public void LoginCallback(String str) {
        Gson g = new Gson();
        LoginInfo info = g.fromJson(str, LoginInfo.class);

        switch (info.getCode()) {
            case 0:
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                SharedPreferences preference = getSharedPreferences("First", MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                if (pwdRemember.isChecked()) {
                    String s = info.getUsername() + "," + info.getPassword();
                    editor.putString("Info", s);
                    editor.apply();

                } else {
                    Log.e("EEE", "取消");
                    if (preference.getString("Info", null) != null) {

                        editor.remove("Info");
                        editor.apply();
                    }
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", info.getUsername());
                startActivity(intent);
                this.finish();
                break;
            case 1:
                Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                break;
            case 2:

                Toast.makeText(this, "登录异常", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "用户名不存在", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "管理员请使用后台登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        name = username.getText().toString();
        psw = password.getText().toString();
        s = util.Login(this, name, psw);
        queue.add(s);

    }
}
