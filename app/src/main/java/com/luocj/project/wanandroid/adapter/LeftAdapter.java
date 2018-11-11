package com.luocj.project.wanandroid.adapter;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.NavigationBean;

import java.security.Policy;
import java.util.ArrayList;

public class LeftAdapter extends BaseQuickAdapter<NavigationBean.DataBean, BaseViewHolder> {
    private ArrayList<Boolean> selected = new ArrayList<>();

    public ArrayList<Boolean> getSelected() {
        return selected;
    }

    public void setSelected(ArrayList<Boolean> selected) {
        this.selected = selected;
    }

    public LeftAdapter(int layoutResId) {
        super(layoutResId);

    }

    @Override
    protected void convert(BaseViewHolder holder, NavigationBean.DataBean item) {
        holder.setText(R.id.tv_title, item.getName());
        holder.getView(R.id.view).setSelected(selected.get(holder.getLayoutPosition()));
    }

    public void setSelect(ArrayList<Boolean> booleans) {
        this.selected = booleans;
        notifyDataSetChanged();
    }
}
