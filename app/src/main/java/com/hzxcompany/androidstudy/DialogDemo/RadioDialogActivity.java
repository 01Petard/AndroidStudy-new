package com.hzxcompany.androidstudy.DialogDemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hzxcompany.androidstudy.R;

public class RadioDialogActivity extends AppCompatActivity {

    private Button mBtnRadio;
    private String animal[] = { "猫", "狗", "猪", "狮子", "老虎", "大象" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_dialog);
        mBtnRadio = findViewById(R.id.btn_radiodialog_1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mBtnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("请选择你喜欢的动物");
                builder.setSingleChoiceItems(animal, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(RadioDialogActivity.this, "你喜欢"+animal[which], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }
}
