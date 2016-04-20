package com.nsu.vcho.Activity;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nsu.vcho.R;
import com.nsu.vcho.dialog.MyPopupWindow;

public class AddTextActivity extends BaseActivity implements View.OnClickListener,TextWatcher {
    Context mContext;
    ImageView clear;
    TextView addText_cancel, addText_commit,can_enter;
    EditText addText_context;
    MyPopupWindow popupWindow;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        if (msg.what<120){
            clear.setVisibility(View.VISIBLE);
            can_enter.setText(msg.what+"");
        }
            if (msg.what>120){
                can_enter.setText("120");
                clear.setVisibility(View.GONE);
            }
        }
    };

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_add_text);
        mContext = this;

    }

    @Override
    public void initView() {
        addText_cancel = (TextView) findViewById(R.id.addText_cancel);
        addText_context = (EditText) findViewById(R.id.addText_context);
        addText_commit = (TextView) findViewById(R.id.addText_commit);
        clear = (ImageView) findViewById(R.id.clear);
        can_enter = (TextView) findViewById(R.id.can_enter);
        addText_context.addTextChangedListener(this);
        clear.setOnClickListener(this);
        addText_cancel.setOnClickListener(this);
        addText_commit.setOnClickListener(this);
    }

    @Override
    public void afterViewLogic() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addText_cancel:
                this.finish();
                break;
            case R.id.addText_commit:
                if (addText_context.getText().toString().length()>120){
                    Toast.makeText(this,"文本超过限制",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"发送成功",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.clear:
                showPopupWindow(v);
                break;
            case R.id.pop_tv1:
                addText_context.setText("");
                popupWindow.dismiss();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        int l = 120-s.length();
        if (l<120&&l!=0){
        handler.sendEmptyMessage(l);
        }
        if (l==120){
            handler.sendEmptyMessage(121);
        }
    }
    private void showPopupWindow(View view) {
        popupWindow = new MyPopupWindow(AddTextActivity.this, this);
        //显示窗口
        popupWindow.showAtLocation(view,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 40);
    }
}
