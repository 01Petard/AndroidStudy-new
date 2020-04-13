package com.hzxcompany.androidstudy.DialogDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hzxcompany.androidstudy.LinearLayout.VerticalActivity;
import com.hzxcompany.androidstudy.LinearLayout.WeightActivity;
import com.hzxcompany.androidstudy.OtherView.CheckBoxActivity;
import com.hzxcompany.androidstudy.R;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Button mBtn0 = findViewById(R.id.btn_fif_0);
        Button mBtn1 = findViewById(R.id.btn_fif_1);
        Button mBtn2 = findViewById(R.id.btn_fif_2);
        Button mBtn3 = findViewById(R.id.btn_fif_3);
        Button mBtn4 = findViewById(R.id.btn_fif_4);
        mBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FifthActivity.this, AllAlertDialogActivity.class);
                startActivity(intent);
            }
        });
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FifthActivity.this, ChoicesDialogActivity.class);
                startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FifthActivity.this, CheckDialogActivity.class);
                startActivity(intent);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FifthActivity.this, CustomeDialogActivity.class);
                startActivity(intent);
            }
        });
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FifthActivity.this, RadioDialogActivity.class);
                startActivity(intent);
            }
        });


    }
}
