package com.hzxcompany.androidstudy.IntentDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hzxcompany.androidstudy.R;


import java.text.SimpleDateFormat;
import java.util.Date;

public class IntentResearch_2 extends AppCompatActivity {

    private TextView mTv_username,mTv_time;
    private Button mBtn_call,mBtn_send;
    private EditText mEt_phone;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("IntentResearch_2","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_research_2);
        mTv_username = findViewById(R.id.tv_username);
        mTv_time = findViewById(R.id.tv_time);
        mBtn_call = findViewById(R.id.btn_call);
        mBtn_send = findViewById(R.id.btn_send);
        mEt_phone = findViewById(R.id.et_phone);
        mTv_time.setText(simpleDateFormat.format(date));
        //接收Intent传递过来的用户名
        final Intent intent = this.getIntent();
        final String username = intent.getStringExtra("username");
        Log.i("IntentResearch_2",username);
        mTv_username.setText(username);
        mBtn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:"+mEt_phone.getText()));
                IntentResearch_2.this.startActivity(intent);
            }
        });
        mBtn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:"+mEt_phone.getText());
                Intent it = new Intent("android.intent.action.SENDTO", uri);
                it.putExtra("sms_body", "你好，"+username);
                IntentResearch_2.this.startActivity(it);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("IntentResearch_2","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("IntentResearch_2","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("IntentResearch_2","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("IntentResearch_2","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("IntentResearch_2","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("IntentResearch_2","onDestory");
    }
}
