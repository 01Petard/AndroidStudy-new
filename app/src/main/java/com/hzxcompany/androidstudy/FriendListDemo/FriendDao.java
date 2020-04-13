package com.hzxcompany.androidstudy.FriendListDemo;

import com.hzxcompany.androidstudy.R;

import java.util.ArrayList;

public class FriendDao {
    private ArrayList<Friend> friends;
    public FriendDao(){
        friends = new ArrayList<Friend>();
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                friends.add(new Friend(R.mipmap.amiya,i,"张小" + i, "女", "66"+i));
            } else {
                friends.add(new Friend(R.mipmap.amiya_round,i,"李小" + i, "男", "55"+i));
            }
        }
    }
    /**
     * 查询所有的好友
     */
    public ArrayList<Friend> searchAll(){
        return friends;
    }
}