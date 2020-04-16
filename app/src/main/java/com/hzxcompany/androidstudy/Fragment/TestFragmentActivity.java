package com.hzxcompany.androidstudy.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hzxcompany.androidstudy.R;

public class TestFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        Button mBtn1 = findViewById(R.id.btn_fragment_1);
        Button mBtn2 = findViewById(R.id.btn_fragment_2);
        getSupportFragmentManager().beginTransaction().add(R.id.linearlayout_container,new TestFragmentTitle(),"title").commitAllowingStateLoss();
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.framelayout_container,new TestFragment1(),"1").commitAllowingStateLoss();
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.framelayout_container,new TestFragment2(),"2").commitAllowingStateLoss();
            }
        });
    }
}
