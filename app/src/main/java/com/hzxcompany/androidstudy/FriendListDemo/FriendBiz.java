package com.hzxcompany.androidstudy.FriendListDemo;

import com.hzxcompany.androidstudy.R;

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
    public void addFriend(int id,String name,String sex,String phone){
        dao.addFriend(id,name,sex,phone);
    }
    public void updateFriend(int id,Friend friend){
        dao.updateFriend(id,friend);
    }

    public void removeFriend(int position){
        dao.removeFriend(position);
    }

}
