package com.hzxcompany.androidstudy.DialogDemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hzxcompany.androidstudy.R;
import com.hzxcompany.androidstudy.RelativeLayout.RelativeLayoutActivity;
import com.hzxcompany.androidstudy.TestDemo.PokerActivity;

public class CustomeDialogActivity extends AppCompatActivity {

    private Button mBtnCustome;
    String sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_dialog);
        mBtnCustome = findViewById(R.id.btn_customedialog_1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mBtnCustome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("注册页面");
                LayoutInflater inflater = LayoutInflater.from(CustomeDialogActivity.this);
                View view = inflater.inflate(R.layout.activity_registered_custome_dialog, null);
                builder.setView(view);
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
                builder.setPositiveButton("确定注册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = mEd_username.getText().toString();
                        String password = mEd_password.getText().toString();
                        String phone = mEd_phone.getText().toString();
                        String email = mEd_email.getText().toString();
                        Toast.makeText(CustomeDialogActivity.this, "用户名：" + username + ",密码：" + password +  "\n性别："+sex+"，电话号码：" + phone +"\n电子邮箱：" + email, Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("取消注册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CustomeDialogActivity.this, "你取消了注册", Toast.LENGTH_LONG).show();
                    }
                }).setCancelable(false).show();
            }
        });
    }
}
