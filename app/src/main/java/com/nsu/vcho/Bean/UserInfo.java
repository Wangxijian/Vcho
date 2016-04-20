package com.nsu.vcho.Bean;

/**
 * Created by tinyyoung on 2016/4/14.
 */
public class UserInfo {
    private int id;
    private int sex;
    private String username;
    private String address;
    private String nickname;
    private int code;
    private String introduction;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", sex=" + sex +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", nickname='" + nickname + '\'' +
                ", code=" + code +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
