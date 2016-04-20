package com.nsu.vcho.Bean;

/**
 * Created by tinyyoung on 2016/4/15.
 */
public class VchoDynamic {
    private String content;
    private int id;
    private String username;
    private String time;
    private String title;
    private String picurl;
    private int code;
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
    public String getPicurl() {
        return picurl;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

}
