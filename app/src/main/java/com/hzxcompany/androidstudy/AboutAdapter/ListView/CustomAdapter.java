package com.hzxcompany.androidstudy.AboutAdapter.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hzxcompany.androidstudy.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<Student> mData = new ArrayList<Student>();
    private LayoutInflater inflater;
    public CustomAdapter(Context context, List<Student> list){
        mData.addAll(list);
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        if(null != mData){
            return mData.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(null != mData && position < mData.size()){
            return mData.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView){
            convertView = inflater.inflate(R.layout.layout_list_item_student,null);
        }
        TextView stuname = convertView.findViewById(R.id.tv_liststu_1);
        TextView stuage = convertView.findViewById(R.id.tv_liststu_2);
        Student stuInfo = (Student)getItem(position);
        if(stuInfo!=null){
            stuname.setText(stuInfo.getName());
            //stuage.setText(Integer.toString(stuInfo.getAge()));
            stuage.setText(String.valueOf(stuInfo.getAge()));
        }
        return  convertView;

    }
}
