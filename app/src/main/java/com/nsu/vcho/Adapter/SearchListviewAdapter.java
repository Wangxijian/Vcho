package com.nsu.vcho.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsu.vcho.Bean.VchoDynamic;
import com.nsu.vcho.R;

import java.util.ArrayList;

/**
 * Created by tinyyoung on 2016/4/15.
 */
public class SearchListviewAdapter extends BaseAdapter {
    private ArrayList<VchoDynamic> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public SearchListviewAdapter(Context context, ArrayList<VchoDynamic> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    class Holder {
        TextView title, time, content, auth;
        ImageView img;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = layoutInflater.inflate(R.layout.serachview_item, null);
            holder.time = (TextView) convertView.findViewById(R.id.seaview_time);
            holder.title = (TextView) convertView.findViewById(R.id.seaview_tit);
            holder.content = (TextView) convertView.findViewById(R.id.seaview_content);
            holder.auth = (TextView) convertView.findViewById(R.id.seaview_auth);
            holder.img = (ImageView) convertView.findViewById(R.id.seaview_img);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.title.setText(list.get(position).getTitle());
        holder.time.setText(list.get(position).getTime());
        holder.content.setText(list.get(position).getContent());
        holder.auth.setText("小编：" + list.get(position).getUsername());
        return convertView;
    }

    public void updataAdapter() {
        notifyDataSetChanged();
    }
}
