package com.luocj.project.wanandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {
    private static SharedPreferences sp = null;
    private static void getSP(Context context){
        if(sp == null){
            sp = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
    }

    public static void putString(Context context,String key,String value){
        getSP(context);
        sp.edit().putString(key,value).commit();
    }

    public static void putInt(Context context,String key,int value){
        getSP(context);
        sp.edit().putInt(key,value).commit();
    }

    public static void putBoolean(Context context,String key,boolean value){
        getSP(context);
        sp.edit().putBoolean(key,value).commit();
    }

    public static String getString(Context context,String key,String defvalue){
        getSP(context);
        return sp.getString(key,defvalue);
    }

    public static int getInt(Context context,String key,int defValue){
        getSP(context);
        return sp.getInt(key,defValue);
    }

    public static boolean getBoolean(Context context,String key,boolean defvalue){
        getSP(context);
        return sp.getBoolean(key,defvalue);
    }
}
