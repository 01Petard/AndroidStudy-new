package com.hzxcompany.androidstudy.FriendListDemo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzxcompany.androidstudy.R;

import java.util.ArrayList;

public class FriendAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Friend> friends;
    public FriendAdapter(Context context, ArrayList<Friend> friends){
        inflater = LayoutInflater.from(context);
        if(friends!=null){
            this.friends = friends;
        }else{
            this.friends = new ArrayList<Friend>();
        }
    }
    /**
     * 返回当前数据集中的数据条数
     */
    @Override
    public int getCount() {
        return friends.size();
    }
    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }
    @Override
    public long getItemId(int position) {
        return friends.get(position).getId();
    }
    /**
     * 返回指定位置数据绑定的item convertView重用
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if(convertView==null){
            convertView = inflater.inflate(R.layout.layout_friend_list_test_item, null);
            holder.iv = convertView.findViewById(R.id.item_img);
            holder.tvId = convertView.findViewById(R.id.item_id);
            holder.tvName = convertView.findViewById(R.id.item_name);
            holder.tvSex = convertView.findViewById(R.id.item_sex);
            holder.tvPhone = convertView.findViewById(R.id.item_phone);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //获取数据
        Friend friend = friends.get(position);
        // 将数据绑定到item界面上
        holder.iv.setImageResource(friend.getHead());
        holder.tvId.setText("ID:"+friend.getId() + "");
        holder.tvName.setText("姓名:"+friend.getName());
        holder.tvSex.setText("性别:"+friend.getSex());
        holder.tvPhone.setText("电话:"+friend.getPhone() + "");
        return convertView;
    }
    class ViewHolder {
        private ImageView iv;
        private TextView tvId;
        private TextView tvName;
        private TextView tvSex;
        private TextView tvPhone;
    }
}