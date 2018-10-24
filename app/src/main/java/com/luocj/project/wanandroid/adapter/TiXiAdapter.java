package com.luocj.project.wanandroid.adapter;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.activity.TagDetailActivity;
import com.luocj.project.wanandroid.activity.WebViewActivity;
import com.luocj.project.wanandroid.bean.TiXiBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class TiXiAdapter extends BaseQuickAdapter<TiXiBean.DataBean, BaseViewHolder> {

    public TiXiAdapter(int layoutResId, @Nullable List<TiXiBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, TiXiBean.DataBean item) {
        holder.setText(R.id.tv_item_tixi, item.getName());
        List<TiXiBean.DataBean.ChildrenBean> children = item.getChildren();
        TagFlowLayout tfl = holder.getView(R.id.tfl);
        ArrayList<String> mVals = new ArrayList<>();
        for (int i = 0; i < item.getChildren().size(); i++) {
            mVals.add(item.getChildren().get(i).getName());
        }

        tfl.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tfl, tfl, false);
                tv.setText(s);
                return tv;
            }
        });

        tfl.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Log.i(TAG, "onTagClick: id -->" + item.getChildren().get(position).getId());
                Intent intent = new Intent(mContext, TagDetailActivity.class);
                intent.putExtra("childbean",item.getChildren().get(position));
                mContext.startActivity(intent);
                return false;
            }
        });
    }
}
