package com.hzxcompany.androidstudy.OtherView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.hzxcompany.androidstudy.R;

public class MarqueenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marqueen);
        TextView mtv1 = (TextView)this.findViewById(R.id.tv_mar_1);
        mtv1.setSelected(true);
        TextView mtv2 = (TextView)this.findViewById(R.id.tv_mar_2);
        mtv1.setSelected(true);
        TextView mtv3 = (TextView)this.findViewById(R.id.tv_mar_3);
        mtv1.setSelected(true);
    }
}
