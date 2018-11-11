package com.luocj.project.wanandroid.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.NavigationBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Random;

public class RightAdapter extends BaseQuickAdapter<NavigationBean.DataBean, BaseViewHolder> {
    public RightAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder holder, NavigationBean.DataBean item) {
        holder.getView(R.id.tv_item_tixi).setVisibility(View.INVISIBLE);
        TagFlowLayout tfl = holder.getView(R.id.tfl);
        ArrayList<String> mVals = new ArrayList<>();
        for (int i = 0; i < item.getArticles().size(); i++) {
            mVals.add(item.getArticles().get(i).getTitle());
            Log.i(TAG, "convert: " + item.getArticles().get(i).getChapterName());
        }
        tfl.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                Random random = new Random();
                int r = random.nextInt(150);
                int g = random.nextInt(150);
                int b = random.nextInt(150);
                TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tfl, tfl, false);
                tv.setTextColor(Color.rgb(r,g,b));
                tv.setText(s);
                return tv;
            }
        });
    }
}
