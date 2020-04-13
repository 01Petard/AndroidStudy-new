package com.hzxcompany.androidstudy.DialogDemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hzxcompany.androidstudy.OtherView.CheckBoxActivity;
import com.hzxcompany.androidstudy.R;

public class CheckDialogActivity extends AppCompatActivity {

    private Button mBtnCheck;
    private String[] lan = {"C","C#","C++","Java","Python","JavaScript","PHP","Ruby","Perl","Pascal"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_dialog);
        mBtnCheck = findViewById(R.id.btn_checkdialog_1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("请选择你会的语言");
                builder.setMultiChoiceItems(lan, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){
                            Toast.makeText(CheckDialogActivity.this, "你会"+lan[which], Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.create().show();
            }
        });
    }
}
