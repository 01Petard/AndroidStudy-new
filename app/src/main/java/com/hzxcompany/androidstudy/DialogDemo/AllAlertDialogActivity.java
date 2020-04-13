package com.hzxcompany.androidstudy.DialogDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hzxcompany.androidstudy.MainActivity;
import com.hzxcompany.androidstudy.R;

public class AllAlertDialogActivity extends AppCompatActivity {

    private Button mBtnChoice,mBtnCheck,mBtnRadio,mBtnCustome;
    private String[] lan = {"C","C#","C++","Java","Python","JavaScript","PHP","Ruby","Perl","Pascal"};
    private String animal[] = { "猫", "狗", "猪", "狮子", "老虎", "大象" };
    private String sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_alert_dialog);
        final AlertDialog.Builder builder_choice = new AlertDialog.Builder(this);
        final AlertDialog.Builder builder_check = new AlertDialog.Builder(this);
        final AlertDialog.Builder builder_radio = new AlertDialog.Builder(this);
        final AlertDialog.Builder builder_custome = new AlertDialog.Builder(this);

        mBtnChoice = findViewById(R.id.btn_choicedialog);
        mBtnCheck = findViewById(R.id.btn_checkdialog);
        mBtnRadio = findViewById(R.id.btn_radiodialog);
        mBtnCustome = findViewById(R.id.btn_customedialog);
        mBtnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder_choice.setTitle("对话框");
                builder_choice.setMessage("你确定要返回MainActivity吗？");
                builder_choice.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(AllAlertDialogActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(AllAlertDialogActivity.this, "欢迎回到MainActivity", Toast.LENGTH_SHORT).show();
                    }
                });
                builder_choice.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AllAlertDialogActivity.this, "你决定不返回MainActivity", Toast.LENGTH_SHORT).show();
                    }
                });
                builder_choice.setNeutralButton("忽略",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AllAlertDialogActivity.this, "中立按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder_choice.create().show();

            }
        });
        mBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder_check.setTitle("请选择你会的语言");
                builder_check.setMultiChoiceItems(lan, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){
                            Toast.makeText(AllAlertDialogActivity.this, "你会"+lan[which], Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder_check.create().show();
            }
        });
        mBtnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder_radio.setTitle("请选择你喜欢的动物");
                builder_radio.setSingleChoiceItems(animal, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AllAlertDialogActivity.this, "你喜欢"+animal[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder_radio.create().show();
            }
        });
        mBtnCustome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder_custome.setTitle("注册页面");
                LayoutInflater inflater = LayoutInflater.from(AllAlertDialogActivity.this);
                View view = inflater.inflate(R.layout.activity_registered_custome_dialog, null);
                builder_custome.setView(view);
                final EditText mEd_username = view.findViewById(R.id.et_reg_1);
                final EditText mEd_password = view.findViewById(R.id.et_reg_2);
                final RadioGroup mEd_sex = view.findViewById(R.id.radgp_sex);
                final EditText mEd_phone = view.findViewById(R.id.et_reg_3);
                final EditText mEd_email = view.findViewById(R.id.et_reg_4);
                mEd_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton radioButton = group.findViewById(checkedId);
                        sex = (String) radioButton.getText();
                    }
                });
                builder_custome.setPositiveButton("确定注册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = mEd_username.getText().toString();
                        String password = mEd_password.getText().toString();
                        String phone = mEd_phone.getText().toString();
                        String email = mEd_email.getText().toString();
                        Toast.makeText(AllAlertDialogActivity.this, "用户名：" + username + ",密码：" + password +  "\n性别："+sex+"，电话号码：" + phone +"\n电子邮箱：" + email, Toast.LENGTH_LONG).show();
                    }
                });
                builder_custome.setNegativeButton("取消注册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AllAlertDialogActivity.this, "你取消了注册", Toast.LENGTH_LONG).show();
                    }
                });
                builder_custome.create().show();
            }
        });
    }
}
