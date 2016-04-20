package com.nsu.vcho.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nsu.vcho.R;

/**
 * Created by Mark-1 on 2016/4/12.
 */
public class HomeFragment extends Fragment {
View view;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }
}
