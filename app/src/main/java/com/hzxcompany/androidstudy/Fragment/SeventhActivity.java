package com.hzxcompany.androidstudy.Fragment;

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

public class SeventhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        Button mBtn1 = findViewById(R.id.btn_sev_1);
        Button mBtn2 = findViewById(R.id.btn_sev_2);
        Button mBtn3 = findViewById(R.id.btn_sev_3);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeventhActivity.this, ContainerActivity.class);
                startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeventhActivity.this, TestFragmentActivity.class);
                startActivity(intent);
            }
        });
    }
}
