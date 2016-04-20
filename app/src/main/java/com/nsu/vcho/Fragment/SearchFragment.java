package com.nsu.vcho.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.nsu.vcho.Adapter.SearchListviewAdapter;
import com.nsu.vcho.Bean.VchoDynamicList;
import com.nsu.vcho.Interface.CallBack;
import com.nsu.vcho.R;
import com.nsu.vcho.Utils.Util;
import com.nsu.vcho.Utils.Util_Volley;
import com.roger.catloadinglibrary.CatLoadingView;

/**
 * Created by Mark-1 on 2016/4/12.
 */
public class SearchFragment extends Fragment implements CallBack {
    View view;
    ListView listView;
    SearchListviewAdapter adapter;
    CatLoadingView mView;
    Util util;
    RequestQueue queue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        mView = new CatLoadingView();
        mView.show(getActivity().getSupportFragmentManager(), "");
        listView = (ListView) view.findViewById(R.id.searchlistview);
        util = Util.getInstance(getActivity());
        queue = Util_Volley.getinstance();
        queue.add(util.getVchoDynamic(this));
        return view;
    }

    @Override
    public void LoginCallback(String str) {
        Log.e("msg", str);
        Gson g = new Gson();
        VchoDynamicList info = g.fromJson(str, VchoDynamicList.class);
        Log.e("msg", info.getList().toString());
        switch (info.getList().get(0).getCode()) {
            case 0:
                adapter = new SearchListviewAdapter(getActivity(), info.getList());
                listView.setAdapter(adapter);
                mView.dismiss();
                break;
            case 1:
                Toast.makeText(getActivity(), "系统错误", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getActivity(), "异常", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
