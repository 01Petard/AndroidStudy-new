package com.hzxcompany.androidstudy.TestDemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hzxcompany.androidstudy.R;

public class PokerActivity extends AppCompatActivity {
    TextView mTv_1;
    ImageView mIv_1, mIv_2, mIv_3;
    Button mBtn_1;
    int[] s1 = {R.mipmap.pk1, R.mipmap.pk2, R.mipmap.pk3};
    int[] s2 = new int[s1.length];//每张牌的下标

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker);
        mTv_1 = findViewById(R.id.tv_pk_1);
        mIv_1 = findViewById(R.id.iv_pk_1);
        mIv_2 = findViewById(R.id.iv_pk_2);
        mIv_3 = findViewById(R.id.iv_pk_3);
        mBtn_1 = findViewById(R.id.btn_pk_1);
        init_pk();
        mIv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageRes();
                setAlp(100);
                //三张牌同时翻开，然后将另外两张设置为透明的，用于区别所选的那张
                setAlp(mIv_1, 255);
//                printInfo(R.mipmap.pk1, 0);
                printInfo(0);
            }
        });
        mIv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageRes();
                setAlp(100);
                setAlp(mIv_2, 255);
//                printInfo(R.mipmap.pk2, 1);
                printInfo(1);
            }
        });
        mIv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageRes();
                setAlp(100);
                setAlp(mIv_3, 255);
//                printInfo(R.mipmap.pk3, 2);
                printInfo(2);
            }
        });
        mBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv_1.setText("猜猜红桃A在哪里");
                //未翻牌时只显示背面的样子
                mIv_1.setImageDrawable(getResources().getDrawable(R.drawable.pk_back));
                mIv_2.setImageDrawable(getResources().getDrawable(R.drawable.pk_back));
                mIv_3.setImageDrawable(getResources().getDrawable(R.drawable.pk_back));
                //还原所有牌的透明度
                setAlp(255);
                //重新洗牌
                init_pk();
            }
        });
    }
    /**
     * 洗牌，给数组s1换顺序
     */
    public void init_pk() {
        Log.i("PokerActivity","==========洗牌==========");
        for (int i = 0; i < 3; i++) {
            int tmp = s1[i];
            int s = (int) (Math.random() * 2);
            s1[i] = s1[s];
            s1[s] = tmp;
        }
        //跟踪每张牌的下标
        for(int j=0;j<s1.length;j++){
            Log.i("PokerActivity","j:"+j);
            switch (s1[j]){
                case R.mipmap.pk1:
                    s2[0] = j;
                    Log.i("PokerActivity","跟踪红桃A的下标："+s2[0]+",j:"+j);
                    break;
                case R.mipmap.pk2:
                    s2[1] = j;
                    Log.i("PokerActivity","跟踪黑桃A的下标："+s2[1]+",j:"+j);
                    break;
                case R.mipmap.pk3:
                    s2[2] = j;
                    Log.i("PokerActivity","跟踪方块J的下标："+s2[2]+",j:"+j);
                    break;
                default:
                    Log.i("PokerActivity","出现意外错误！！！"+",j:"+j);
                    break;
            }
        }
    }
    /**
     * 初始化牌
     */
    public void setImageRes() {
        mIv_1.setImageResource(s1[0]);
        mIv_2.setImageResource(s1[1]);
        mIv_3.setImageResource(s1[2]);
    }
    /**
     * 给所有牌设置同一透明度
     * @透明度0~255 alp
     */
    public void setAlp(int alp){
        mIv_1.setImageAlpha(alp);
        mIv_2.setImageAlpha(alp);
        mIv_3.setImageAlpha(alp);
    }
    /**
     * 给其中一张牌设置单独透明色
     * @组件 iv
     * @透明度0~255 v_alp
     */
    public void setAlp(ImageView iv, int iv_alp) {
        iv.setImageAlpha(iv_alp);
    }
    /**
     * 判断当前的牌是不是我们开始时期望的牌
     * @图片的路径id image_id
     * @图片的路径id在s1数组中的下标 index
     */
    public void printInfo(int image_id, int index) {
        if (s1[index] == image_id) {
            mTv_1.setText("恭喜你，猜对了！");
        } else {
            mTv_1.setText("你猜错了，继续努力...");
        }
    }
    /**
     * 判断当前选择的是不是指定的牌
     * @指定的牌的下标 index
     */
    public void printInfo(int index){
        Log.i("PokerActivity","当前牌的下标："+index);
        if(s1[index]==s1[s2[0]]){
            mTv_1.setText("恭喜你，猜对了！");
            Log.i("PokerActivity","猜中了");
        } else {
            mTv_1.setText("你猜错了，继续努力...");
            Log.i("PokerActivity","没有猜中");
        }
    }
}
