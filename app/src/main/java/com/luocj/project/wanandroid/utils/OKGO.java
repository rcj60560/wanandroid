package com.luocj.project.wanandroid.utils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

public class OKGO {

    public static void get(String url, String tag, StringCallback callback) {
        OkGo.<String>get(url)
                .tag(tag)
                .execute(callback);
    }

}
