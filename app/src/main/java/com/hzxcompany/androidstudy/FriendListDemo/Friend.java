package com.hzxcompany.androidstudy.FriendListDemo;

import com.hzxcompany.androidstudy.R;

public class Friend {
    private int icon;
    private String id;
    private String name;
    private String sex;
    private String phone;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int head) {
        this.icon = head;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Friend(String id,String name,String sex,String phone){
        this(R.mipmap.friend_icon,id,name,sex,phone);
    }
    public Friend(int icon,String id, String name, String sex, String phone) {
        this.icon = icon;
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }
}
