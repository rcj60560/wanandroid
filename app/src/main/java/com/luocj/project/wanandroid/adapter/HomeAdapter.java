package com.luocj.project.wanandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.activity.LoginActivity;
import com.luocj.project.wanandroid.activity.WebViewActivity;
import com.luocj.project.wanandroid.bean.HomeDetailBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.SPUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeAdapter extends BaseQuickAdapter<HomeDetailBean.DataBean.DatasBean, BaseViewHolder> {

    private Context context;

    public HomeAdapter(Context activity, int layoutResId, @Nullable List<HomeDetailBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
        this.context = activity;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final HomeDetailBean.DataBean.DatasBean item) {
        holder.setText(R.id.tv_item_title, item.getTitle());
        holder.setText(R.id.tv_itemt_desc, item.getDesc().trim());
        holder.setText(R.id.tv_item_author_name, item.getAuthor());
//        holder.setText(R.id.tv_item_time_,ms2Date(item.getPublishTime()));
        holder.setText(R.id.tv_item_time_, item.getNiceDate());
        holder.setText(R.id.tv_chaptername, item.getSuperChapterName() + "/" + item.getChapterName());
        holder.getView(R.id.rl_rootview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("link", item.getLink());
                mContext.startActivity(intent);
            }
        });

        holder.getView(R.id.iv_like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String result = (String) SPUtils.get(mContext, Constants.LOGIN_SAVE, "");
//                Log.i(TAG, "onClick: " + result);
//                if (TextUtils.isEmpty(string)) {
//                    Toast.makeText(mContext, "登录了", Toast.LENGTH_SHORT).show();
//                } else {
//                    mContext.startActivity(new Intent(mContext, LoginActivity.class));
//                    Toast.makeText(mContext, "未登录 去登录", Toast.LENGTH_SHORT).show();
//                }

                String string = SPUtils.getInstance().getString(Constants.LOGIN_SAVE, "");
                if (TextUtils.isEmpty(string)) {
                    mContext.startActivity(new Intent(mContext, LoginActivity.class));
                    Toast.makeText(mContext, "未登录 去登录", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i(TAG, "onClick: " + "dianzan");
                    Log.i(TAG, "onClick: " + SPUtils.getInstance().getString(Constants.LOGIN_SAVE, "default"));

                }

            }
        });

    }

    public static String ms2Date(long _ms) {
        Date date = new Date(_ms);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return format.format(date);
    }

    public static String ms2DateOnlyDay(long _ms) {
        Date date = new Date(_ms);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return format.format(date);
    }

}
