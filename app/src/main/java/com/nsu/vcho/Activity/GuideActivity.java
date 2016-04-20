package com.nsu.vcho.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.nsu.vcho.Adapter.GuideAdapter;
import com.nsu.vcho.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity implements ViewPager.OnPageChangeListener,View.OnTouchListener{
    private ViewPager viewPager;
    private GuideAdapter vpAdapter;
    private List<View> views;
    private ImageView[] dots;
    private int[] ids = {R.id.point_1, R.id.point_2, R.id.point_3};

    protected int currentItem = 0;
    private float lastX;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_guide);
        Log.e("TAG","Guide");
    }

    @Override
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_guide);

    }

    @Override
    public void afterViewLogic() {
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        views.add(inflater.inflate(R.layout.page_one, null));
        views.add(inflater.inflate(R.layout.page_two, null));
        views.add(inflater.inflate(R.layout.page_three, null));
        vpAdapter = new GuideAdapter(this,views);
        viewPager.setAdapter(vpAdapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setOnTouchListener(this);
        initDots();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < ids.length; i++) {
            if (position == i) {
                dots[i].setImageResource(R.drawable.point_selected);
                currentItem = i;
            } else {
                dots[i].setImageResource(R.drawable.point);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private void initDots() {
        dots = new ImageView[views.size()];
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) findViewById(ids[i]);
            dots[i].setImageResource(R.drawable.point);
            dots[0].setImageResource(R.drawable.point_selected);
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                break;
            case MotionEvent.ACTION_UP:

                if (lastX - event.getX() > 100 && currentItem == dots.length - 1) {
                    //跳转到主页面
                    Intent i = new Intent(this, LoginActivity.class);
                    i.putExtra("userInfo","aaa");
                    startActivity(i);
                    this.finish();
                }
                break;
        }
        return false;
    }
}
