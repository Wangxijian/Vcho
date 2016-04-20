package com.nsu.vcho.Activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.nsu.vcho.Bean.RegisterInfo;
import com.nsu.vcho.Interface.CallBack;
import com.nsu.vcho.R;
import com.nsu.vcho.Utils.Util;
import com.nsu.vcho.Utils.Util_Volley;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener,CallBack {
    private EditText reg_user, reg_pwd, reg_pwd1, reg_answer;
    private Spinner spinner;
    private Button reg_btn;
    private int question_index;
    private String answer;
    RequestQueue queue;
    Util util;
    StringRequest s;
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_regist);
    }

    @Override
    public void initView() {
        reg_user = (EditText) findViewById(R.id.reg_user);
        reg_pwd = (EditText) findViewById(R.id.reg_pwd);
        reg_pwd1 = (EditText) findViewById(R.id.reg_pwd1);
        reg_answer = (EditText) findViewById(R.id.reg_answer);
        spinner = (Spinner) findViewById(R.id.spinner);
        reg_btn = (Button) findViewById(R.id.reg_btn);
        reg_btn.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void afterViewLogic() {
        util = Util.getInstance(this);
        queue = Util_Volley.getinstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg_btn:
                register();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        question_index = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void register() {
        if (TextUtils.isEmpty(reg_user.getText().toString())){
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(reg_pwd.getText().toString())){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(reg_pwd1.getText().toString())){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(reg_answer.getText().toString())){
            Toast.makeText(this,"密码提示的答案不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (!reg_pwd.getText().toString().equals(reg_pwd1.getText().toString())){
            Toast.makeText(this,"密码不相同",Toast.LENGTH_SHORT).show();
            return;
        }
        s = util.register(this,reg_user.getText().toString(),reg_pwd.getText().toString(),question_index,reg_answer.getText().toString());
        queue.add(s);

    }

    @Override
    public void LoginCallback(String str) {
        Gson g = new Gson();
        RegisterInfo info = g.fromJson(str,RegisterInfo.class);
       switch (info.getCode()){
           case 0:
               Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
               break;
           case 1:
               Toast.makeText(this,"用户名已被注册",Toast.LENGTH_SHORT).show();
               break;
       }
    }
}
