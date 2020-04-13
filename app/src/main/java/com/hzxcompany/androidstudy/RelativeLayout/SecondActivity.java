package com.hzxcompany.androidstudy.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.hzxcompany.androidstudy.LinearLayout.FirstActivity;
import com.hzxcompany.androidstudy.LinearLayout.HorizontalActivity;
import com.hzxcompany.androidstudy.LinearLayout.VerticalActivity;
import com.hzxcompany.androidstudy.LinearLayout.WeightActivity;
import com.hzxcompany.androidstudy.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button mBtn1 = findViewById(R.id.btn_sec_1);
        Button mBtn2 = findViewById(R.id.btn_sec_2);
        Button mBtn3 = findViewById(R.id.btn_sec_3);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, EditTestActivity.class);
                startActivity(intent);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, RegisteredActivity.class);
                startActivity(intent);
            }
        });
    }
}
