package com.hzxcompany.androidstudy.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hzxcompany.androidstudy.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private TextView mTvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvTitle = findViewById(R.id.tv_title);
        //实例化AFragment
        AFragment aFragment = AFragment.newInstance("我是参数");
        //把AFragment添加到Activity中
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment,"a").commitAllowingStateLoss();
    }

    @Override
    public void onClick(String text) {
        mTvTitle.setText(text);
    }
}
