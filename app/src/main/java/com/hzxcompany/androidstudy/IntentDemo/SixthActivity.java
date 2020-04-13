package com.hzxcompany.androidstudy.IntentDemo;

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

public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        Button mBtn1 = findViewById(R.id.btn_six_1);
        Button mBtn2 = findViewById(R.id.btn_six_2);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_START");
                intent.addCategory("android.intent.category.MyCategory");
                String data = "从SixthActivity转跳到TestIntentActivity了";
                intent.putExtra("转跳1", data);
                startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SixthActivity.this, IntentResearch_1.class);
                startActivity(intent);
            }
        });
    }
}
