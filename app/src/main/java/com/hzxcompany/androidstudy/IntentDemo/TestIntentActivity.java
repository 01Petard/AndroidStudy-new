package com.hzxcompany.androidstudy.IntentDemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hzxcompany.androidstudy.R;

public class TestIntentActivity extends AppCompatActivity {
    private Button mBtn1,mBtn2,mBtn3,mBtn4,mBtn5,mBtn6,mBtn7,mBtn8,mBtn9,mBtn10,mBtn11,mBtn12;

    public TestIntentActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intent);
        TextView mTv = findViewById(R.id.tv_intent_1);
        mTv.setSelected(true);
        mBtn1 = this.findViewById(R.id.btn_intent_1);
        mBtn2 = this.findViewById(R.id.btn_intent_2);
        mBtn3 = this.findViewById(R.id.btn_intent_3);
        mBtn4 = this.findViewById(R.id.btn_intent_4);
        mBtn5 = this.findViewById(R.id.btn_intent_5);
        mBtn6 = this.findViewById(R.id.btn_intent_6);
        mBtn7 = this.findViewById(R.id.btn_intent_7);
        mBtn8 = this.findViewById(R.id.btn_intent_8);
        mBtn9 = this.findViewById(R.id.btn_intent_9);
        mBtn10 = this.findViewById(R.id.btn_intent_10);
        mBtn11 = this.findViewById(R.id.btn_intent_11);
        mBtn12 = this.findViewById(R.id.btn_intent_12);
        //接收Intent信息
        Intent intent = this.getIntent();
        String data = intent.getStringExtra("转跳1");
        Log.d("TestIntentActivity", data);

        mBtn1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://www.baidu.com"));
                TestIntentActivity.this.startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:13248684099"));
                TestIntentActivity.this.startActivity(intent);
            }
        });
        mBtn3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:29.88525897,121.57900597");
                Intent it = new Intent("android.intent.action.VIEW", uri);
                TestIntentActivity.this.startActivity(it);
            }
        });
        mBtn4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent("android.intent.action.VIEW");
                it.putExtra("Huang Zexiao", "利用隐式Intent发送发送短信或彩信");
                it.setType("vnd.android-dir/mms-sms");
                TestIntentActivity.this.startActivity(it);
            }
        });
        mBtn5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:13248684099");
                Intent it = new Intent("android.intent.action.SENDTO", uri);
                it.putExtra("sms_body", "利用隐式Intent发送发送短信");
                TestIntentActivity.this.startActivity(it);
            }
        });
        mBtn6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("/storage/emulated/0/DCIM/Screenshots/IMG_20191222_172336.jpg");
                Intent it = new Intent("android.intent.action.SEND");
                it.putExtra("sms_body", "some text");
                it.putExtra("android.intent.extra.STREAM", uri);
                it.setType("image/png/jpg");
                TestIntentActivity.this.startActivity(it);
            }
        });
        mBtn7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("mailto:1520394133@qq.com.com");
                Intent it = new Intent("android.intent.action.SENDTO", uri);
                TestIntentActivity.this.startActivity(it);
            }
        });
        mBtn8.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent("android.intent.action.SEND");
                String[] tos = new String[]{"me@abc.com"};
                String[] ccs = new String[]{"you@abc.com"};
                it.putExtra("android.intent.extra.EMAIL", tos);
                it.putExtra("android.intent.extra.CC", ccs);
                it.putExtra("android.intent.extra.TEXT", "The email body text");
                it.putExtra("android.intent.extra.SUBJECT", "The email subject text");
                it.setType("message/rfc822");
                TestIntentActivity.this.startActivity(Intent.createChooser(it, "Choose Email Client"));
            }
        });
        mBtn9.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent("android.intent.action.VIEW");
//                File file = new File("/storage/emulated/0/DCIM/Screenshots/Camera/VID_20190802_180533.mp4");
//                Uri photoURI = FileProvider.getUriForFile(TestIntentActivity.this.getApplicationContext(), "com.ixuea.courses.testsystemui.fileprovider", file);
//                intent.addFlags(1);
//                intent.addFlags(268435456);
//                intent.setDataAndType(photoURI, "vedio/*");
//                TestIntentActivity.this.startActivity(intent);
            }
        });
        mBtn10.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String url = "https://www.bilibili.com/video/av58147093";
                String extension = MimeTypeMap.getFileExtensionFromUrl(url);
                String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
                Intent mediaIntent = new Intent("android.intent.action.VIEW");
                mediaIntent.setDataAndType(Uri.parse(url), mimeType);
                TestIntentActivity.this.startActivity(mediaIntent);
            }
        });
        this.mBtn11.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent("android.intent.action.SEND");
                it.putExtra("android.intent.extra.SUBJECT", "The email subject text");
                it.putExtra("android.intent.extra.STREAM", "/storage/emulated/0/netease/cloudmusic/Music/呦猫UNEKO - 梦回还.mp3");
                it.setType("audio/mp3");
                TestIntentActivity.this.startActivity(Intent.createChooser(it, "Choose Email Client"));
            }
        });
        this.mBtn12.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.WEB_SEARCH");
                intent.putExtra("query", "肺炎疫情");
                TestIntentActivity.this.startActivity(intent);
            }
        });
    }
}
