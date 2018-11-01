package com.luocj.project.wanandroid.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luocj.project.wanandroid.MainActivity;
import com.luocj.project.wanandroid.R;

import java.io.UTFDataFormatException;

public class SplashActivity extends AppCompatActivity {

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            if (what > 0) {
                what--;
                time.setText(what + " s");
                Message obtain = Message.obtain();
                obtain.what = what;
                mHandler.sendMessageDelayed(obtain, 1000);
            } else {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }
    };
    private TextView time;
    private int count = 0;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initData();
    }

    private void initData() {
        String url = "https://camo.githubusercontent.com/8524a3d101484a10c56624bb70ef2a92bf5843ab/6874747073" +
                "3a2f2f646979636f64652e62302e7570616979756e2e636f6d2f757365722f6176617461722f323436382e6a7067";
        Glide.with(SplashActivity.this)
                .load(url)
                .into(imageview);

        Message message = Message.obtain();
        message.what = 3;
        mHandler.sendMessageDelayed(message, 1000);
    }

    private void initView() {
        time = findViewById(R.id.tv_time);
        imageview = findViewById(R.id.image);

    }
}
