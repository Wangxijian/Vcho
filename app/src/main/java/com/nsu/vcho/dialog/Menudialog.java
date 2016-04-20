package com.nsu.vcho.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.nsu.vcho.Activity.AddTextActivity;
import com.nsu.vcho.Activity.MainActivity;
import com.nsu.vcho.R;

/**
 * Created by tinyyoung on 2016/4/14.
 */
public class Menudialog extends Dialog implements View.OnClickListener {
    Context context;
    View localView;
    ImageView closemenu,addText;

    public Menudialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        LayoutInflater inflater = ((MainActivity) context).getLayoutInflater();
        localView = inflater.inflate(R.layout.mainmenu_layout, null);
        localView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_bottom_to_top));
        setContentView(localView);
        // 这句话起全屏的作用
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        initView();

    }

    private void initView() {
        closemenu = (ImageView) findViewById(R.id.closemenu);
        closemenu.setOnClickListener(this);
        addText = (ImageView) findViewById(R.id.addText);
        addText.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.closemenu:
                this.dismiss();
                break;
            case R.id.addText:
                Intent i  = new Intent(getContext(), AddTextActivity.class);
                getContext().startActivity(i);
                this.dismiss();
                break;
        }
    }
}
