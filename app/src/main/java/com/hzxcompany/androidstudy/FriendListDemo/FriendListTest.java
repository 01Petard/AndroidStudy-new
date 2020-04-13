package com.hzxcompany.androidstudy.FriendListDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.hzxcompany.androidstudy.R;

import java.util.ArrayList;

public class FriendListTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list_test);
        FriendBiz biz = new FriendBiz();
        ArrayList<Friend> friends = biz.getAllFriends();
        //实例化listview
        ListView lv = findViewById(R.id.lvfriend);
        //创建adapter对象
        /*
        Context家族很复杂，Context本身是一个抽象类，而ContextImpl，ContextWrapper，Activity，Service，Application等都是它的直接或间接子类
        这里使用了Activity作为Context类型的参数，传入后向上转型可以调用父类的方法，使LayutInflate的from方法返回LayoutInflate对象
         */
        FriendAdapter adapter = new FriendAdapter(this, friends);
        //设置adapter
        lv.setAdapter(adapter);
    }
}
