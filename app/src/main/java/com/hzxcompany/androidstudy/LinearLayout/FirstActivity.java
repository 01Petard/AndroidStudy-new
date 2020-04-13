package com.hzxcompany.androidstudy.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hzxcompany.androidstudy.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button mBtn1 = findViewById(R.id.btn_fir_1);
        Button mBtn2 = findViewById(R.id.btn_fir_2);
        Button mBtn3 = findViewById(R.id.btn_fir_3);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, HorizontalActivity.class);
                startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, VerticalActivity.class);
                startActivity(intent);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, WeightActivity.class);
                startActivity(intent);
            }

        });

    }
}
