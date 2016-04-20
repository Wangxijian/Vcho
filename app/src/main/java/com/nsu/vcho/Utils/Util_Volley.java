package com.nsu.vcho.Utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Mark-1 on 2016/4/12.
 */
public class Util_Volley {
    private Util_Volley(){
    }
    private static RequestQueue mQueue;
    //初始化
    public static void initialze(Context context) {
        if (mQueue == null) {
            synchronized (Util_Volley.class) {
                mQueue = Volley.newRequestQueue(context);
            }

        }
    }
    //创建队列
    public static RequestQueue getinstance(){
        if (mQueue != null) {
            return mQueue;
        }else{
            return null;
        }
    }
}
