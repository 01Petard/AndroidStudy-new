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

public class MyListTestAdapter extends BaseAdapter {
    private List<Student> mData = new ArrayList<Student>();
    private LayoutInflater inflater;
    public MyListTestAdapter(Context context, List<Student> list){
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
        if(mData != null  && position < mData.size()){
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_list_view_test, null);
        }
        TextView tv_banji = convertView.findViewById(R.id.tv_listtest_1);
        TextView tv_id = convertView.findViewById(R.id.tv_listtest_2);
        TextView tv_name = convertView.findViewById(R.id.tv_listtest_3);
        Student stuInfo = (Student) getItem(position);
        if (stuInfo != null) {
            tv_banji.setText(stuInfo.getBanji());
            tv_id.setText(String.valueOf(stuInfo.getAge()));
            tv_name.setText(stuInfo.getName());
        }
        return convertView;
    }
}
