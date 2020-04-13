package com.hzxcompany.androidstudy.DialogDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hzxcompany.androidstudy.MainActivity;
import com.hzxcompany.androidstudy.R;

public class ChoicesDialogActivity extends AppCompatActivity {

    private Button mBtn_choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices_dialog);
        mBtn_choice = findViewById(R.id.btn_choicesdialog_1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mBtn_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("提示");
                builder.setMessage("你确定要返回MainActivity吗？");
                builder.setPositiveButton("我确定要返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ChoicesDialogActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(ChoicesDialogActivity.this, "欢迎回到MainActivity", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("算了，还是呆在这儿吧", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ChoicesDialogActivity.this, "你决定不返回MainActivity", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("中立按钮",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ChoicesDialogActivity.this, "忽略", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();

            }
        });
//        mBtn_choice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                builder.setTitle("对话框");
//                builder.setMessage("你确定要返回MainActivity吗？");
//                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(ChoicesDialogActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        Toast.makeText(ChoicesDialogActivity.this, "欢迎回到MainActivity", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(ChoicesDialogActivity.this, "你决定不返回MainActivity", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setNeutralButton("忽略",new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(ChoicesDialogActivity.this, "中立按钮", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.create().show();
//
//            }
//        });
    }
}
