package com.qk365.demo.bean;


import com.eyunhome.baseappframework.db.sqlite.annotation.Table;

@Table(name="user")
public class UserBean {
    private int id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
