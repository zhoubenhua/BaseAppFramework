package com.qk365.demo.bean;

import java.io.Serializable;

/**
 * Created by qk365-0023 on 2015/8/4.
 * 登录返回的data下的对像
 */
public class LoginInfo implements Serializable {
    private String username;//登陆的用户名
    private String id;//用户id号


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
