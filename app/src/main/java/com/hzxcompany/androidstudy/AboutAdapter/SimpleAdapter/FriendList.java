package com.hzxcompany.androidstudy.AboutAdapter.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.hzxcompany.androidstudy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ListView lv= findViewById(R.id.listView1);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("id", "001");
        map1.put("name", "章安");
        map1.put("phone", "12345");
        map1.put("sex", "男");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("sex", "男");
        map2.put("id", "002");
        map2.put("name", "李四");
        map2.put("phone", "34789");
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("sex", "女");
        map3.put("id", "003");
        map3.put("name", "王五");
        map3.put("phone", "12370");
        Map<String, String> map4 = new HashMap<String, String>();
        map4.put("sex", "男");
        map4.put("id", "004");
        map4.put("name", "周八");
        map4.put("phone", "02300");
        Map<String, String> map5 = new HashMap<String, String>();
        map5.put("sex", "女");
        map5.put("id", "005");
        map5.put("name", "赵六");
        map5.put("phone", "12900");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        // 构造simpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.layout_friend_list_item,
                new String[] { "sex", "id", "name", "phone" }, new int[] {
                R.id.tvsex, R.id.tvid, R.id.tvname, R.id.tvphone });
        lv.setAdapter(adapter);
    }
}
