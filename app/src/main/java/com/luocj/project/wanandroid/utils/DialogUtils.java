package com.luocj.project.wanandroid.utils;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;

import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.widget.dialog.BaseNiceDialog;
import com.luocj.project.wanandroid.widget.dialog.NiceDialog;
import com.luocj.project.wanandroid.widget.dialog.ViewConvertListener;

public class DialogUtils {


    private static BaseNiceDialog dialog;

    public static void showDialog(@LayoutRes int layoudId, int width, ViewConvertListener listener, FragmentManager fragmentManager) {
        dialog = NiceDialog.init()
                .setLayoutId(layoudId)
                .setConvertListener(listener)
                .setWidth(width)
                .setDimAmount(0.5f)
                .setOutCancel(false)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(fragmentManager);
    }

    public static void dissmiss(){
        if (dialog!=null){
            dialog.dismiss();
        }
    }
}
