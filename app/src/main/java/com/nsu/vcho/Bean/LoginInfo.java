package com.nsu.vcho.Bean;

/**
 * Created by tinyyoung on 2016/4/11.
 */
public class LoginInfo {
    private String userName;
    private int code;
    private String passWord;
    private int id;

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getUsername() {
        return userName;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public String getPassword() {
        return passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "username='" + userName + '\'' +
                ", code=" + code +
                ", password='" + passWord + '\'' +
                ", id=" + id +
                '}';
    }
}
