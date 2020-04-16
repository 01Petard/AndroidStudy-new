package com.hzxcompany.androidstudy.AboutAdapter.GridView;

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

    private List<String> mData = new ArrayList<>();
    private LayoutInflater flater;

    public CustomAdapter(Context context, List<String> list) {
        flater = LayoutInflater.from(context);//加载布局
        mData.addAll(list);
    }

    public int getCount() {
        if (mData == null || mData.isEmpty()) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        if (mData == null || position > mData.size() - 1) {
            return null;
        }
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = flater.inflate(R.layout.layout_grid_layout_item, null);
        TextView txtName = convertView.findViewById(R.id.grid_item_txt);
        String value = mData.get(position);
        if (value != null) {
            txtName.setText(value);
        }
        return convertView;
    }
}
