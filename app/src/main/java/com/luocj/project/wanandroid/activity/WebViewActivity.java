package com.luocj.project.wanandroid.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.luocj.project.wanandroid.R;

public class WebViewActivity extends BaseActivity {

    private static final String TAG = WebViewActivity.class.getSimpleName();
    private AgentWeb mAgentWeb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        LinearLayout webview = findViewById(R.id.ll_webview);
        String link = getIntent().getStringExtra("link");
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(webview, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(link);
        Log.i(TAG, "onCreate: " + link);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();

    }
}
