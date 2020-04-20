package com.hzxcompany.androidstudy.FriendListDemo;

import com.hzxcompany.androidstudy.R;

import java.util.ArrayList;

public class FriendDao {
    private ArrayList<Friend> friends;
    public FriendDao(){
        friends = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                friends.add(new Friend(R.mipmap.friend_icon,i+1,"张小" + i+1, "女", "66"+i));
            } else {
                friends.add(new Friend(R.mipmap.friend_icon,i+1,"李小" + i+1, "男", "55"+i));
            }
        }
    }
    /**
     * 查询所有的好友
     */
    public ArrayList<Friend> searchAll(){
        return friends;
    }
    public void addFriend(int id,String name,String sex,String phone){
        friends.add(new Friend(R.mipmap.friend_icon,id,name,sex,phone));
    }
    public void updateFriend(int id,Friend friend){
        friends.set(id,friend);
    }
    public void removeFriend(int position){
        friends.remove(position); //删除集合中的对象
    }

}