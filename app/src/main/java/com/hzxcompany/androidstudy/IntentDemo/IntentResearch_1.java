package com.hzxcompany.androidstudy.IntentDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hzxcompany.androidstudy.R;

public class IntentResearch_1 extends AppCompatActivity {

    private EditText mEt_user, mEt_password;
    private Button mBtn_login, mBtn_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("IntentResearch_1","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_research_1);
        mEt_user = findViewById(R.id.et_user);
        mEt_password = findViewById(R.id.et_password);
        mBtn_login = findViewById(R.id.btn_login);
        mBtn_sign = findViewById(R.id.btn_sign);
        mBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = String.valueOf(mEt_user.getText());
                String password = String.valueOf(mEt_password.getText());
                String user_default = "hzx";
                String password_default = "123";
                if (password.equals(password_default)) {
                    Intent intent = new Intent(IntentResearch_1.this, IntentResearch_2.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                } else {
                    Toast.makeText(IntentResearch_1.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("IntentResearch_1","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("IntentResearch_1","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("IntentResearch_1","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("IntentResearch_1","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("IntentResearch_1","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("IntentResearch_1","onDestory");
    }
}
