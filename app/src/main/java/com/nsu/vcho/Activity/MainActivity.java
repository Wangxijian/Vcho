package com.nsu.vcho.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.nsu.vcho.Fragment.HomeFragment;
import com.nsu.vcho.Fragment.MessageFragment;
import com.nsu.vcho.Fragment.SearchFragment;
import com.nsu.vcho.Fragment.UserFragment;
import com.nsu.vcho.Interface.CallBack;
import com.nsu.vcho.R;
import com.nsu.vcho.dialog.Menudialog;

public class MainActivity extends BaseActivity implements CallBack, View.OnClickListener {
    ImageView home, msg, search, user, mainmenu;
    FragmentManager fragmentManager;
    HomeFragment homeFragment;
    MessageFragment messageFragment;
    SearchFragment searchFragment;
    UserFragment userFragment;
    String username;

    public String getUsername() {
        return username;
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        home = (ImageView) findViewById(R.id.home1);
        msg = (ImageView) findViewById(R.id.msg);
        search = (ImageView) findViewById(R.id.search);
        user = (ImageView) findViewById(R.id.user);
        mainmenu = (ImageView) findViewById(R.id.mainmenu);
        mainmenu.setOnClickListener(this);
        home.setOnClickListener(this);
        msg.setOnClickListener(this);
        search.setOnClickListener(this);
        user.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        setFragment(0);
    }

    @Override
    public void afterViewLogic() {

    }

    @Override
    public void LoginCallback(String str) {

    }

    Dialog dialog;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home1:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                setFragment(0);
                break;
            case R.id.msg:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                setFragment(1);
                break;
            case R.id.search:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                setFragment(2);
                break;
            case R.id.user:
                setFragment(3);
                break;
            case R.id.mainmenu:
                dialog = new Menudialog(this);
               // WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
               // lp.alpha = 1.0f;
                //dialog.getWindow().setAttributes(lp);
                dialog.show();
                break;

        }
    }

    private void setFragment(int index) {
        clearState();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        clearFragment(transaction);


        switch (index) {
            case 0:
                home.setImageResource(R.drawable.home_fill);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                msg.setImageResource(R.drawable.community_fill);
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    transaction.show(messageFragment);
                }
                break;
            case 2:
                search.setImageResource(R.drawable.attention_fill);
                if (searchFragment == null) {
                    searchFragment = new SearchFragment();
                    transaction.add(R.id.content, searchFragment);
                } else {
                    transaction.show(searchFragment);
                }
                break;
            case 3:
                user.setImageResource(R.drawable.people_fill);
                if (userFragment == null) {
                    userFragment = new UserFragment();
                    transaction.add(R.id.content, userFragment);
                } else {
                    transaction.show(userFragment);
                }
                break;

        }
        transaction.commit();
    }

    private void clearFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);

        }
        if (messageFragment != null) {
            transaction.hide(messageFragment);

        }
        if (searchFragment != null) {
            transaction.hide(searchFragment);

        }
        if (userFragment != null) {
            transaction.hide(userFragment);

        }
    }

    private void clearState() {
        home.setImageResource(R.drawable.home);
        msg.setImageResource(R.drawable.community);
        search.setImageResource(R.drawable.attention);
        user.setImageResource(R.drawable.people);
    }
}
