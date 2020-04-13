package com.hzxcompany.androidstudy.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hzxcompany.androidstudy.MainActivity;
import com.hzxcompany.androidstudy.R;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb, mPbCustome;
    private Button mBtnStart, mBtnRestart, mBtnPd1, mBtnPd2, mBtnCustome,mBtnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPb = findViewById(R.id.pb2);
        mPbCustome = findViewById(R.id.pb3);
        mPbCustome.setAnimation(AnimationUtils.loadAnimation(ProgressActivity.this, R.anim.icon_progress));
        mBtnPd1 = findViewById(R.id.btn_progress_dialog1);
        mBtnPd2 = findViewById(R.id.btn_progress_dialog2);
        mBtnCustome = findViewById(R.id.btn_progress_dialog3);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mBtnReturn = findViewById(R.id.btn_return);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnRestart = findViewById(R.id.btn_restart);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
        mBtnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPb.setProgress(0);
                handler.removeMessages(0);
            }
        });
        //滚动加载条ProgressDialog
        mBtnPd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setIcon(R.drawable.arknights);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载...");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(ProgressActivity.this, "取消了进度条...", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressActivity.this, "确定加载", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressActivity.this, "取消加载", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setCancelable(false);
                progressDialog.show();

            }
        });
        //水平加载条ProgressDialog
        mBtnPd2.setOnClickListener(new View.OnClickListener() {
            int flag=0;
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setIcon(R.drawable.arknights);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(progressDialog.getProgress()==progressDialog.getMax()){
                            Toast.makeText(ProgressActivity.this, "下载完成！", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ProgressActivity.this, "下载中断！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(progressDialog.getProgress()!=progressDialog.getMax()){
                            Toast.makeText(ProgressActivity.this, "下载中断！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                progressDialog.show();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            while (progressDialog.getProgress() < progressDialog.getMax()) {
                                progressDialog.setProgress(progressDialog.getProgress() + 4);
                                Thread.sleep(100);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                if(progressDialog.getProgress()==progressDialog.getMax()){
                    progressDialog.setMessage("下载完成！");
                    Toast.makeText(ProgressActivity.this, "加载完成！", Toast.LENGTH_SHORT).show();
                }
                progressDialog.show();
            }
        });
        //自定义滚动加载条ProgressDialog
        mBtnCustome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(ProgressActivity.this).inflate(R.layout.layout_progressbar, null);
                ProgressBar pb = view.findViewById(R.id.pb_custome);
                //给ProgressBar添加动画效果
                pb.setAnimation(AnimationUtils.loadAnimation(ProgressActivity.this, R.anim.icon_progress));
                builder.setTitle("提示")
                        .setView(view)//这步关键，如果不写，这个view是不会显示出来的
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ProgressActivity.this, "确定加载", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressActivity.this, "取消加载", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgressActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mPb.getProgress() < mPb.getMax()) {
                handler.postDelayed(runnable, 100);
            } else {
                Toast.makeText(ProgressActivity.this, "加载完成！", Toast.LENGTH_SHORT).show();
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb.setProgress(mPb.getProgress() + 2);
            handler.sendEmptyMessage(0);
        }
    };
}
