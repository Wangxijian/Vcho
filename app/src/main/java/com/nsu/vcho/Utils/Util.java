package com.nsu.vcho.Utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nsu.vcho.Interface.CallBack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mark-1 on 2016/4/11.
 */
public class Util {

    private static Util util;

    private Util() {
    }

    public static Util getInstance(Context context) {
        if (util == null) {
            util = new Util();
        }

        return util;
    }

    public StringRequest Login(final CallBack callBack, String username, String pwd) {

        StringRequest stringRequest = new StringRequest(
                "http://120.27.38.69:10000/VchoServer/LoginSer?name=" + username + "&pwd=" + pwd,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        callBack.LoginCallback(s);
                        Log.e("AAA",""+s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        return stringRequest;
    }
    public StringRequest getUserInfo(final CallBack callBack, String username) {

        StringRequest stringRequest = new StringRequest(
                "http://120.27.38.69:10000/VchoServer/GetUserInfo?name=" + username,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        callBack.LoginCallback(s);
                        Log.e("AAA",""+s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        return stringRequest;
    }
    public StringRequest getVchoDynamic(final CallBack callBack) {

        StringRequest stringRequest = new StringRequest(
                "http://120.27.38.69:10000/VchoServer/GetVchoPublishSer",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        callBack.LoginCallback(s);
                        Log.e("AAA",""+s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        return stringRequest;
    }

    public StringRequest register(final CallBack callBack, String username, String pwd,int question_index,String answer) {

        StringRequest stringRequest = new StringRequest(
                "http://120.27.38.69:10000/VchoServer/RegisterSer?name=" + username + "&pwd=" + pwd+"&index="+question_index+"&answer="+answer,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        callBack.LoginCallback(s);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        return stringRequest;
    }

    public boolean isUserName(String str) {
        Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]{2,4}$");
        Matcher m = p.matcher(str);
        boolean b = m.lookingAt();
        return b;
    }

}