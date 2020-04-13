package com.hzxcompany.androidstudy.RelativeLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hzxcompany.androidstudy.R;

public class RegisteredActivity extends AppCompatActivity {
    private EditText mEt1,mEt2,mEt3,mEt4;
    private Button mBtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        mEt1 = findViewById(R.id.et_reg_1);
        mEt2 = findViewById(R.id.et_reg_2);
        mEt3 = findViewById(R.id.et_reg_3);
        mEt4 = findViewById(R.id.et_reg_4);
        mBtn1 = findViewById(R.id.btn_reg_1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RegisteredActivity","用户名："+mEt1.getText().toString());
                Log.i("RegisteredActivity","密码："+mEt2.getText().toString());
                Log.i("RegisteredActivity","电话号码："+mEt3.getText().toString());
                Log.i("RegisteredActivity","性别"+mEt4.getText().toString());

            }
        });
    }
}
