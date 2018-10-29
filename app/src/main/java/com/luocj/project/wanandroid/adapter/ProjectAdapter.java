package com.luocj.project.wanandroid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.ProjectListBean;

public class ProjectAdapter extends BaseQuickAdapter<ProjectListBean.DataBean.DatasBean,BaseViewHolder> {
    public ProjectAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder holder, ProjectListBean.DataBean.DatasBean item) {
        holder.setText(R.id.tv_item_title,item.getChapterName());
        holder.setText(R.id.tv_item_author,item.getAuthor());
        holder.setText(R.id.tv_itemt_desc,item.getDesc());
    }
}
