package com.luocj.project.wanandroid;

import android.app.Application;

import com.luocj.project.wanandroid.utils.OKGO;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.SPCookieStore;
import com.tencent.bugly.crashreport.CrashReport;

import okhttp3.OkHttpClient;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initNet();

        initBuggly();

    }

    private void initBuggly() {
        CrashReport.initCrashReport(getApplicationContext(), "6751012d6b", false);
    }

    private void initNet() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));
        OkGo.getInstance().setOkHttpClient(builder.build());
        OkGo.getInstance().init(this);
    }
}
