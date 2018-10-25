package com.luocj.project.wanandroid.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.luocj.project.wanandroid.MainActivity;
import com.luocj.project.wanandroid.R;

public class SplashActivity extends AppCompatActivity {

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            if (what > 0) {
                what--;
                time.setText(what + "s");
                Message obtain = Message.obtain();
                obtain.what = what;
                mHandler.sendMessageDelayed(obtain, 1000);
            }else {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        }
    };
    private TextView time;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initData();
    }

    private void initData() {
        Message message = Message.obtain();
        message.what = 3;
        mHandler.sendMessage(message);
    }

    private void initView() {
        time = findViewById(R.id.tv_time);

    }
}
