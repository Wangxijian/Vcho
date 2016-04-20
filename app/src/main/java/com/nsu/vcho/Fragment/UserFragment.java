package com.nsu.vcho.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nsu.vcho.Activity.MainActivity;
import com.nsu.vcho.Activity.UserInfoActivity;
import com.nsu.vcho.Activity.UserSettingActivity;
import com.nsu.vcho.R;

/**
 * Created by Mark-1 on 2016/4/12.
 */
public class UserFragment extends Fragment implements View.OnClickListener {
    View view;
    LinearLayout setting_lin, userinfo_lin;
    String username;
    TextView me_username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);
        setting_lin = (LinearLayout) view.findViewById(R.id.setting_btn);
        setting_lin.setOnClickListener(this);
        me_username = (TextView) view.findViewById(R.id.me_username);
        username = ((MainActivity) getActivity()).getUsername();
        me_username.setText(username);
        userinfo_lin = (LinearLayout) view.findViewById(R.id.userinfo_lin);
        userinfo_lin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_btn:
                Intent intent = new Intent(getActivity(), UserSettingActivity.class);
                startActivity(intent);
                break;
            case R.id.userinfo_lin:
                Intent intent2 = new Intent(getActivity(), UserInfoActivity.class);
                intent2.putExtra("username",username);
                startActivity(intent2);
                break;
        }
    }
}
