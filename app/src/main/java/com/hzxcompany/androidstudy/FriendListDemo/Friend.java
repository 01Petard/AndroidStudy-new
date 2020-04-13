package com.hzxcompany.androidstudy.FriendListDemo;

import java.util.HashMap;
import java.util.Map;

public class Friend {
    private int head;
    private int id;
    private String name;
    private String sex;
    private String phone;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Friend() {
    }

    public Friend(int head,int id, String name, String sex, String phone) {
        this.head = head;
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }
}
