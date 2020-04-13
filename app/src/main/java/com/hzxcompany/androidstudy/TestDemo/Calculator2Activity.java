package com.hzxcompany.androidstudy.TestDemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hzxcompany.androidstudy.R;


public class Calculator2Activity extends AppCompatActivity {

    private EditText mEtv_result;
    private Button mBtn_clear,mBtn_1,mBtn_2,mBtn_3,mBtn_4,mBtn_5,mBtn_6,mBtn_7,mBtn_8,mBtn_9,mBtn_0,mBtn_add,mBtn_dec,mBtn_plus,mBtn_divide,mBtn_point,mBtn_is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);
        mEtv_result = findViewById(R.id.et_cal2_result);
        mBtn_1 = findViewById(R.id.btn_cal2_1);
        mBtn_2 = findViewById(R.id.btn_cal2_2);
        mBtn_3 = findViewById(R.id.btn_cal2_3);
        mBtn_4 = findViewById(R.id.btn_cal2_4);
        mBtn_5 = findViewById(R.id.btn_cal2_5);
        mBtn_6 = findViewById(R.id.btn_cal2_6);
        mBtn_7 = findViewById(R.id.btn_cal2_7);
        mBtn_8 = findViewById(R.id.btn_cal2_8);
        mBtn_9 = findViewById(R.id.btn_cal2_9);
        mBtn_0 = findViewById(R.id.btn_cal2_0);
        mBtn_is = findViewById(R.id.btn_cal2_is);
        mBtn_point = findViewById(R.id.btn_cal2_point);
        mBtn_clear = findViewById(R.id.btn_cal2_clear);
        mBtn_add = findViewById(R.id.btn_cal2_add);
        mBtn_dec = findViewById(R.id.btn_cal2_dec);
        mBtn_plus = findViewById(R.id.btn_cal2_plus);
        mBtn_divide = findViewById(R.id.btn_cal2_divide);
        setListeners();
    }
    public void setListeners(){
        OnClick onClick = new OnClick();
        mBtn_1.setOnClickListener(onClick);
        mBtn_2.setOnClickListener(onClick);
        mBtn_3.setOnClickListener(onClick);
        mBtn_4.setOnClickListener(onClick);
        mBtn_5.setOnClickListener(onClick);
        mBtn_6.setOnClickListener(onClick);
        mBtn_7.setOnClickListener(onClick);
        mBtn_8.setOnClickListener(onClick);
        mBtn_9.setOnClickListener(onClick);
        mBtn_0.setOnClickListener(onClick);
        mBtn_is.setOnClickListener(onClick);
        mBtn_point.setOnClickListener(onClick);
        mBtn_clear.setOnClickListener(onClick);
        mBtn_add.setOnClickListener(onClick);
        mBtn_dec.setOnClickListener(onClick);
        mBtn_plus.setOnClickListener(onClick);
        mBtn_divide.setOnClickListener(onClick);
    }
    public class OnClick implements View.OnClickListener{
        String s1;//存储前一个数字
        String s2;//存储后一个数字
        String[] logic_sign={"+","-","*","/"};
        String sign;//进行最终结果运算时的符号
        double result=0;//计算器输出的结果

        private void getcal(String number) {
            //first获取当前文本框内的数字
            String first = null;
            if (mEtv_result != null) {
                //将文本框内的字符
                first = mEtv_result.getText().toString();
            }
            //second是按下的数字
            String second = number;
            //文本框内新的数字应该是：旧的字符串+新的数字，更新first就可以了
            first = first + second;
            //将文本框内的数字设为新的first
            mEtv_result.setText(String.valueOf(first));
        }
        private void operate(String logic){
            //判断运算符号
            for(int i=0;i<=logic_sign.length-1;i++){
                if(logic==logic_sign[i]){
                    sign = logic_sign[i];
                    Log.i("cal2culator2Activity","sign:"+sign);
                    break;
                }
            }
            //获取当前文本框内的数字
            s1 = mEtv_result.getText().toString();
            //获取完毕后清空，准备获取后一个数字
            mEtv_result.setText(null);
        }
        private void getResult(){
            if(sign==null)return;
            //获取后一个数字，然后判断符号、输出结果，最后修改文本框的值
            s2 = mEtv_result.getText().toString();
            //选择运算符号
            switch (sign){
                case "+":
                    result = Float.parseFloat(s1)+Float.parseFloat(s2);
                    break;
                case "-":
                    result = Float.parseFloat(s1)-Float.parseFloat(s2);
                    break;
                case "*":
                    result = Float.parseFloat(s1)*Float.parseFloat(s2);
                    break;
                case "/":
                    result = Float.parseFloat(s1)/Float.parseFloat(s2);
                    break;
                default:
                    Log.i("Calculator2Activity","未知符号");
                    break;
            }
            Log.i("Calculator2Activity","result:"+result);
            //输出结果
            mEtv_result.setText(String.valueOf(result));
        }
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_cal2_clear:
                    mEtv_result.setText(null);
                    Log.i("Calculator2Activity","按下:C，清空");
                    break;
                case R.id.btn_cal2_1:
                    getcal("1");
                    Log.i("Calculator2Activity","按下:1");
                    break;
                case R.id.btn_cal2_2:
                    getcal("2");
                    Log.i("Calculator2Activity","按下:2");
                    break;
                case R.id.btn_cal2_3:
                    getcal("3");
                    Log.i("Calculator2Activity","按下:3");
                    break;
                case R.id.btn_cal2_4:
                    getcal("4");
                    Log.i("Calculator2Activity","按下:4");
                    break;
                case R.id.btn_cal2_5:
                    getcal("5");
                    Log.i("Calculator2Activity","按下:5");
                    break;
                case R.id.btn_cal2_6:
                    getcal("6");
                    Log.i("Calculator2Activity","按下:6");
                    break;
                case R.id.btn_cal2_7:
                    getcal("7");
                    Log.i("Calculator2Activity","按下:7");
                    break;
                case R.id.btn_cal2_8:
                    getcal("8");
                    Log.i("Calculator2Activity","按下:8");
                    break;
                case R.id.btn_cal2_9:
                    getcal("9");
                    Log.i("Calculator2Activity","按下:9");
                    break;
                case R.id.btn_cal2_0:
                    getcal("0");
                    Log.i("Calculator2Activity","按下:0");
                    break;
                case R.id.btn_cal2_add:
                    operate("+");
                    Log.i("Calculator2Activity","按下:+");
                    break;
                case R.id.btn_cal2_dec:
                    operate("-");
                    Log.i("Calculator2Activity","按下:-");
                    break;
                case R.id.btn_cal2_plus:
                    operate("*");
                    Log.i("Cal2culator2Activity","按下:*");
                    break;
                case R.id.btn_cal2_divide:
                    operate("/");
                    Log.i("Calculator2Activity","按下:/");
                    break;
                case R.id.btn_cal2_is:
                    getResult();
                    Log.i("Calculator2Activity","按下=，输出结果");
                    break;
                case R.id.btn_cal2_point:
                    Log.i("Calculator2Activity","按下.");
                    break;
            }
        }
    }
}
