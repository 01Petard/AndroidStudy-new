package com.hzxcompany.androidstudy.FriendListDemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hzxcompany.androidstudy.R;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class FriendListTest extends AppCompatActivity {
    ListView lv;
    FriendAdapter adapter;
    TextView id;//好友编号
    EditText name;//好友姓名
    EditText phone;//好友电话号码
    RadioGroup sexGroup;
    RadioButton sex;//好友性别
    FriendBiz biz = new FriendBiz();
    //注意！此处的friends列表不是FriendDao类的friends，仅仅是一个替身
    ArrayList<Friend> friends = biz.getAllFriends();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list_test);
        lv = findViewById(R.id.lvfriend);
        //创建adapter对象
        /*
        Context家族很复杂，Context本身是一个抽象类，而ContextImpl，ContextWrapper，Activity，Service，Application等都是它的直接或间接子类
        这里使用了Activity作为Context类型的参数，传入后向上转型可以调用父类的方法，使LayutInflate的from方法返回LayoutInflate对象
         */
        adapter = new FriendAdapter(this, friends);
        //设置adapter
        lv.setAdapter(adapter);
        this.registerForContextMenu(lv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.friend_menu,menu);
        setIconsVisible(menu,true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                View add_view = LayoutInflater.from(FriendListTest.this).inflate(R.layout.friend_add,null);
                id = add_view.findViewById(R.id.friend_id);
                name = add_view.findViewById(R.id.friend_name);
                phone = add_view.findViewById(R.id.friend_phone);
                sexGroup = add_view.findViewById(R.id.friend_sex);
                sexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        sex = group.findViewById(checkedId);
                    }
                });
                //获取好友列表最后一位好友的对象
                Friend friend_last = friends.get(adapter.getCount()-1);
                //获取最后一位好友的id值
                String friend_add_id = friend_last.getId();
                //将对话框中的id值设为最后一位好友的id值+1
                id.setText(String.valueOf(Integer.parseInt(friend_add_id)+1));
                final AlertDialog alertDialog = new AlertDialog.Builder(FriendListTest.this)
                        .setView(add_view)
                        .setTitle("添加")
                        .setIcon(R.drawable.friend_add)
                        .setPositiveButton("确定",null)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(false)
                        .show();
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i=0;i<adapter.getCount();i++){
                            Friend friend_temp = friends.get(i);
                            if(id.getText().toString().equals(friend_temp.getId())){
                                Toast.makeText(FriendListTest.this, "id号重复！", Toast.LENGTH_SHORT).show();
                                //return后会保持原对话框状态
                                return;
                            }
                        }
                        friends = biz.getAllFriends();
                        adapter.addItem(new Friend(id.getText().toString(),name.getText().toString(),sex.getText().toString(),phone.getText().toString()));
                        adapter.notifyDataSetChanged();
                        Toast.makeText(FriendListTest.this, "好友信息添加完毕！", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });
                break;
            case R.id.menu_log:
                AlertDialog.Builder builder = new AlertDialog.Builder(FriendListTest.this);
                builder.setTitle("开发日志")
                        .setMessage("2020.4.19（日）：实现大部分功能。\n" +
                                "2020.4.20（一）：完成所有功能。" +
                                "2020.4.26（日）：修改部分功能：id号可以修改；优化部分代码。\n")
                        .setPositiveButton("确定",null)
                        .setNegativeButton("取消",null)
                        .setCancelable(true)
                        .show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*反射得到menu的setOptionalIconsVisible方法，这样就可以看到icon了，因为谷歌默认屏蔽了显示icon*/
    private void setIconsVisible(Menu menu, boolean flag) {
        //判断menu是否为空
        if(menu != null) {
            try {
                //如果不为空,就反射拿到menu的setOptionalIconsVisible方法
                Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                //暴力访问该方法
                method.setAccessible(true);
                //调用该方法显示icon
                method.invoke(menu, flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderIcon(R.drawable.arknights);
        menu.setHeaderTitle("操作");
        menu.add(1,0,1,"详情");
        menu.add(1,1,1,"修改");
        menu.add(1,2,1,"删除");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        AlertDialog.Builder builder = new AlertDialog.Builder(FriendListTest.this);
        final int position = info.position;
        final Friend friend = (Friend) adapter.getItem(position);
        switch(item.getItemId()){
            case 0: //详情
                builder.setTitle("详情")
                        .setIcon(R.drawable.friend_info)
                        .setMessage("好友信息：\n"+
                                "编号："+friend.getId()+"\n"+
                                "姓名："+friend.getName()+"\n"+
                                "性别："+friend.getSex()+"\n"+
                                "电话："+friend.getPhone())
                        .setPositiveButton("确定",null)
                        .setNegativeButton("取消",null)
                        .setCancelable(false)
                        .show();
                break;
            case 1://修改
                LayoutInflater inflater = LayoutInflater.from(FriendListTest.this);
                View update_view = inflater.inflate(R.layout.friend_update,null);
                id = update_view.findViewById(R.id.friend_id);
                name = update_view.findViewById(R.id.friend_name);
                phone = update_view.findViewById(R.id.friend_phone);
                sexGroup = update_view.findViewById(R.id.friend_sex);
                //给朋友信息设置信息初始值
                id.setText(String.valueOf(friend.getId()));
                name.setText(String.valueOf(friend.getName()));
                phone.setText(String.valueOf(friend.getPhone()));
                if(friend.getSex().equals("男")){
                    sex = sexGroup.findViewById(R.id.friend_sex_male);
                }
                else if(friend.getSex().equals("女")){
                    sex = sexGroup.findViewById(R.id.friend_sex_female);
                }
                else{
                    Toast.makeText(this, "呐呐呐，难道真的还有第三种性别吗？不会吧不会吧不会吧？！", Toast.LENGTH_SHORT).show();
                }
                sex.setChecked(true);
                //建造对话框
                final AlertDialog alertDialog = new AlertDialog.Builder(FriendListTest.this)
                        .setView(update_view)
                        .setTitle("修改")
                        .setIcon(R.drawable.friend_update)
                        .setPositiveButton("确定", null)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(false)
                        .show();
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i=0;i<adapter.getCount();i++){
                            Friend friend_temp = friends.get(i);
                            if(id.getText().toString().equals(friend_temp.getId())){
                                Toast.makeText(FriendListTest.this, "id号重复！", Toast.LENGTH_SHORT).show();
                                //return后会保持原对话框状态
                                return;
                            }
                        }
                        friend.setId(id.getText().toString());
                        friend.setName(String.valueOf(name.getText()));
                        friend.setPhone(String.valueOf(phone.getText()));
                        if(!sex.isChecked()){
                            String ssex = sex.getText().toString();
                            if(ssex.equals("男")){
                                friend.setSex("女");
                            }else{
                                friend.setSex("男");
                            }
                        }
                        adapter.updateItem(position,friend);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(FriendListTest.this, "好友信息修改完毕！", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });
                break;
            case 2://删除
                builder.setTitle("提示")
                        .setIcon(R.drawable.friend_warn)
                        .setMessage("好友信息：\n"+
                                "编号："+friend.getId()+"\n"+
                                "姓名："+friend.getName()+"\n"+
                                "性别："+friend.getSex()+"\n"+
                                "电话："+friend.getPhone()+"\n"+
                                "\n你确定要删除吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.removeItem(position);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FriendListTest.this, "好友已删除！", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .setCancelable(false)
                        .show();
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
