package com.hzxcompany.androidstudy.AboutAdapter.ListView;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.hzxcompany.androidstudy.R;

public class ListViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        //第一步，找到控件
        ListView list = findViewById(R.id.lv_listtest_1);
        //第二步，初始化一个Adapter对象，两个参数，一个是被填充的对象，另一个是填充内容
        MyListTestAdapter myListTestAdapter = new MyListTestAdapter(ListViewTestActivity.this,new Student().getData());
        //第三步，给视图设置Adapter
        list.setAdapter(myListTestAdapter);
    }
}
