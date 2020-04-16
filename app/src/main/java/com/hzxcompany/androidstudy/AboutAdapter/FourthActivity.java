package com.hzxcompany.androidstudy.AboutAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hzxcompany.androidstudy.AboutAdapter.GridView.GridViewActivity;
import com.hzxcompany.androidstudy.AboutAdapter.ListView.ListViewActivity;
import com.hzxcompany.androidstudy.AboutAdapter.ListView.ListViewTestActivity;
import com.hzxcompany.androidstudy.AboutAdapter.SimpleAdapter.FriendList;
import com.hzxcompany.androidstudy.R;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*用于转跳各种视图的页面*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Button mBtn1 = findViewById(R.id.btn_fou_1);
        Button mBtn2 = findViewById(R.id.btn_fou_2);
        Button mBtn3 = findViewById(R.id.btn_fou_3);
        Button mBtn4 = findViewById(R.id.btn_fou_4);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, ListViewTestActivity.class);
                startActivity(intent);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, GridViewActivity.class);
                startActivity(intent);
            }

        });
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, FriendList.class);
                startActivity(intent);
            }

        });

    }
}
