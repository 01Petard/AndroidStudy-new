package com.hzxcompany.androidstudy.OtherView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hzxcompany.androidstudy.LinearLayout.FirstActivity;
import com.hzxcompany.androidstudy.LinearLayout.HorizontalActivity;
import com.hzxcompany.androidstudy.LinearLayout.VerticalActivity;
import com.hzxcompany.androidstudy.LinearLayout.WeightActivity;
import com.hzxcompany.androidstudy.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button mBtn1 = findViewById(R.id.btn_thi_1);
        Button mBtn2 = findViewById(R.id.btn_thi_2);
        Button mBtn3 = findViewById(R.id.btn_thi_3);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, CheckBoxActivity.class);
                startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, RadioButtonActivity.class);
                startActivity(intent);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
