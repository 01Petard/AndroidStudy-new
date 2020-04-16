package com.hzxcompany.androidstudy.AboutAdapter.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.hzxcompany.androidstudy.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        GridView gridView=findViewById(R.id.gridview);
        CustomAdapter adapter=new CustomAdapter(this,getData());
        gridView.setAdapter(adapter);
    }

    private List<String> getData(){
        List<String> data=new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        data.add("9");
        return  data;

    }
}
