package com.hzxcompany.androidstudy.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hzxcompany.androidstudy.R;

public class AFragment extends Fragment {

    private BFragment bFragment;
    private TextView mTvTitle;
    private Button mBtnChange,mBtnReset,mBtnMessage;
    private String title;
    private IOnMessageClick listener;

    public AFragment(){ }
    public AFragment(String title){ this.title = title; }

    public static AFragment newInstance(String title){
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        aFragment.setArguments(bundle);
        return aFragment;
    }
    public interface IOnMessageClick{
        void onClick(String text);
    }
    //当fragment依附到Activity里时，会调用onAttach方法
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (IOnMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity必须实现IOnMessageClick接口");
        }
    }

    @Nullable
    @Override
    //onCreateView是创建的时候调用
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.i("AFragment","----onCreateView----");
        //返回一个View类型的组件
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    //onViewCreated是在onCreateView后被触发的事件
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_title);
//        mTvTitle.setText("woshicanshua");
        if(getArguments() != null){
            mTvTitle.setText(getArguments().getString("title"));
        }
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                //当前的fragment就是AFragment的一个实例，它通过findFragmentByTag找到了ContainerActivity页面的aFragment
                if(fragment != null){
                    //如果说fragment找到了，不为空，那就将fragment隐藏，再在它上面叠加一层bFragment，利用回退栈可以去掉bFragment，重新显示隐藏的fragment
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    //replace=remove+add，直接replace的话，会导致fragment的内容没有保存
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("我是新文字");
            }
        });
        mBtnMessage = view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("你好");
                listener.onClick("你好啊");

            }
        });


    }
}
