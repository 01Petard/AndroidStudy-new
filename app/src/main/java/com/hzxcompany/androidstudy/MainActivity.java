package com.hzxcompany.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.hzxcompany.androidstudy.AboutAdapter.FourthActivity;
import com.hzxcompany.androidstudy.DialogDemo.FifthActivity;
import com.hzxcompany.androidstudy.Fragment.ContainerActivity;
import com.hzxcompany.androidstudy.FriendListDemo.FriendListTest;
import com.hzxcompany.androidstudy.IntentDemo.SixthActivity;
import com.hzxcompany.androidstudy.LinearLayout.FirstActivity;
import com.hzxcompany.androidstudy.OtherView.MarqueenActivity;
import com.hzxcompany.androidstudy.OtherView.ThirdActivity;
import com.hzxcompany.androidstudy.ProgressBar.ProgressActivity;
import com.hzxcompany.androidstudy.RelativeLayout.SecondActivity;
import com.hzxcompany.androidstudy.TestDemo.Calculator1Activity;
import com.hzxcompany.androidstudy.TestDemo.Calculator2Activity;
import com.hzxcompany.androidstudy.TestDemo.PokerActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtn1,mBtn2,mBtn3,mBtn4,mBtn5,mBtn6,mBtn7,mBtn8,mBtn9,mBtn10,mBtn11,mBtn12,mBtn13;
//    private  Button mBtnIntent,mBtnMarqueen,mBtnPk,mBtnRadio,mBtnCheck,mBtnImageView;

    public MainActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn1 = findViewById(R.id.btn_main_1);//线性布局
        mBtn2 = findViewById(R.id.btn_main_2);//相对布局
        mBtn3 = findViewById(R.id.btn_main_3);//计算器（表格）
        mBtn4 = findViewById(R.id.btn_main_4);//计算器（网格）
        mBtn5 = findViewById(R.id.btn_main_5);//跑马灯
        mBtn6 = findViewById(R.id.btn_main_6);//单选+复选+图片
        mBtn7 = findViewById(R.id.btn_main_7);//Intent
        mBtn8 = findViewById(R.id.btn_main_8);//猜扑克
        mBtn9 = findViewById(R.id.btn_main_9);//Adapter有关的布局
        mBtn10 = findViewById(R.id.btn_main_10);//好友列表
        mBtn11 = findViewById(R.id.btn_main_11);//对话框
        mBtn12 = findViewById(R.id.btn_main_12);//Fragment演示
        mBtn13 = findViewById(R.id.btn_main_13);//ProgressBar和ProgressDialog
        setListeners();
    }

    public void showToast(View view) { Toast.makeText(this, "我被点击了", Toast.LENGTH_SHORT).show(); }

    public void setListeners() {
        MainActivity.OnClick onClick = new MainActivity.OnClick();
        mBtn1.setOnClickListener(onClick);
        mBtn2.setOnClickListener(onClick);
        mBtn3.setOnClickListener(onClick);
        mBtn4.setOnClickListener(onClick);
        mBtn5.setOnClickListener(onClick);
        mBtn6.setOnClickListener(onClick);
        mBtn7.setOnClickListener(onClick);
        mBtn8.setOnClickListener(onClick);
        mBtn9.setOnClickListener(onClick);
        mBtn10.setOnClickListener(onClick);
        mBtn11.setOnClickListener(onClick);
        mBtn12.setOnClickListener(onClick);
        mBtn13.setOnClickListener(onClick);
    }

    public void sendMessage(View view) {
        Log.i("MainActivity", "Hello");
    }

    public class OnClick implements OnClickListener {
        public void onClick(View v) {
            Intent intent = null;
            switch(v.getId()) {
                case R.id.btn_main_1:
                    intent = new Intent(MainActivity.this, FirstActivity.class);
                    break;
                case R.id.btn_main_2:
                    intent = new Intent(MainActivity.this, SecondActivity.class);
                    break;
                case R.id.btn_main_3:
                    intent = new Intent(MainActivity.this, Calculator1Activity.class);
                    break;
                case R.id.btn_main_4:
                    intent = new Intent(MainActivity.this, Calculator2Activity.class);
                    break;
                case R.id.btn_main_5:
                    intent = new Intent(MainActivity.this, MarqueenActivity.class);
                    break;
                case R.id.btn_main_6:
                    intent = new Intent(MainActivity.this, ThirdActivity.class);
                    break;
                case R.id.btn_main_7:
//                    intent = new Intent("android.intent.action.ACTION_START");
//                    intent.addCategory("android.intent.category.MyCategory");
//                    String data = "从MainActivity转跳到TestIntentActivity了";
//                    intent.putExtra("转跳1", data);
                    intent = new Intent(MainActivity.this, SixthActivity.class);
                    break;
                case R.id.btn_main_8:
                    intent = new Intent(MainActivity.this, PokerActivity.class);
                    break;
                case R.id.btn_main_9:
                    intent = new Intent(MainActivity.this, FourthActivity.class);
                    break;
                case R.id.btn_main_10:
                    intent = new Intent(MainActivity.this, FriendListTest.class);
                    break;
                case R.id.btn_main_11:
                    intent = new Intent(MainActivity.this, FifthActivity.class);
                    break;
                case R.id.btn_main_12:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_main_13:
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;
                default:
                    Toast.makeText(MainActivity.this,"转跳时遇到未知错误！",Toast.LENGTH_LONG).show();
                    break;
            }
            startActivity(intent);
        }
    }
}

