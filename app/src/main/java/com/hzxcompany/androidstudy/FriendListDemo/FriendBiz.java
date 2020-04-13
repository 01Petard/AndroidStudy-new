package com.hzxcompany.androidstudy.FriendListDemo;

import java.util.ArrayList;

public class FriendBiz {
    private FriendDao dao ;
    public FriendBiz(){
        dao = new FriendDao();
    }
    /**
     * 获取所有的好友信息
     */
    public ArrayList<Friend> getAllFriends(){
        return dao.searchAll();
    }
}
