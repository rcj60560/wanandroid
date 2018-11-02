package com.luocj.project.wanandroid.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.PublicBean;
import com.luocj.project.wanandroid.bean.WxArticleBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.OKGO;
import com.luocj.project.wanandroid.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 公众号页面
 */

public class PublicActivity extends AppCompatActivity {
    private static final String TAG = PublicActivity.class.getSimpleName();
    private Context mContext;
    private String url = "http://wanandroid.com/wxarticle/chapters/json";
    private int id = -1;
    private RecyclerView rvTitle;
    private RecyclerView rvRight;
    private TitleAdapter adapter;
    private int contentPage = 1;
    private ContentAdapter adapterRight;
    private SmartRefreshLayout smartrefreshlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);
        this.mContext = this;
        initView();
        initData();
    }

    private void initData() {
        OKGO.get(url, "left", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
//                ArrayList<PublicBean> titles = new ArrayList<>();
//                List<PublicBean> list = JSON.parseArray(response.body(), PublicBean.class);
//                if (list != null) {
//                    for (int i = 0; i < list.size(); i++) {
//                        titles.add(list.get(i));
//                    }
//                }
//                adapter = new TitleAdapter(R.layout.item_title, titles);
//                rvTitle.setAdapter(adapter);
//                adapter.setNewData(titles);
//                id = titles.get(0).getId();
//                getContent(id, true);

                PublicBean publicBean = JSONObject.parseObject(response.body(), PublicBean.class);
                if (publicBean.getErrorCode() == 0) {
                    List<PublicBean.DataBean> data = publicBean.getData();
                    if (data != null && data.size() > 0) {
                        adapter = new TitleAdapter(R.layout.item_title, data);
                        rvTitle.setAdapter(adapter);
                        id = data.get(0).getId();
                        getContent(id, true);
                    }
                } else {
                    Toast.makeText(mContext, publicBean.getErrorMsg(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);

            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });


    }

    private void initView() {
        //左边
        rvTitle = findViewById(R.id.recyclerview_public_left);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        rvTitle.setLayoutManager(linearLayoutManager);


        //右边
        rvRight = findViewById(R.id.recyclerview_public_right);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(mContext);
        rvRight.setLayoutManager(linearLayoutManager1);
        adapterRight = new ContentAdapter(R.layout.item_content);
        rvRight.setAdapter(adapterRight);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        smartrefreshlayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refresh(refreshLayout, false);
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refresh(refreshLayout, true);
            }
        });

    }

    /**
     * 刷新内容
     *
     * @param refreshLayout
     * @param b
     */
    private void refresh(RefreshLayout refreshLayout, boolean b) {
        refreshLayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                getContent(id, b);
            }
        }, 2000);
    }


    private class TitleAdapter extends BaseQuickAdapter<PublicBean.DataBean, BaseViewHolder> {
        private HashMap<Integer, Boolean> map = new HashMap<>();

        public TitleAdapter(int layoutResId, @Nullable List<PublicBean.DataBean> data) {
            super(layoutResId, data);
            if (data != null) {
                for (int i = 0; i < data.size(); i++) {
                    if (i == 0) {
                        map.put(i, true);
                    } else {
                        map.put(i, false);
                    }
                }
            }
        }

        @Override
        protected void convert(BaseViewHolder holder, PublicBean.DataBean item) {
            holder.setText(R.id.tv_public_title, item.getName());
            View line = holder.getView(R.id.bottom_line);
            TextView title = holder.getView(R.id.tv_public_title);
            title.setOnClickListener(v -> {
                for (int i = 0; i < map.size(); i++) {
                    if (i == holder.getLayoutPosition()) {
                        map.put(i, true);
                    } else {
                        map.put(i, false);
                    }
                }
                adapter.notifyDataSetChanged();
                id = item.getId();
                getContent(id, true);

            });

            line.setSelected(map.get(holder.getLayoutPosition()));

        }

    }

    private void getContent(int id, boolean isrefresh) {
        if (!isrefresh) {
            contentPage++;
        } else {
            contentPage = 1;
        }
        String url = "http://www.wanandroid.com/wxarticle/list/" + id + "/" + contentPage + "/json";
        OKGO.get(url, "content", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                WxArticleBean wxArticleBean = JSONObject.parseObject(response.body(), WxArticleBean.class);
                List<WxArticleBean.DataBean.DatasBean> datas = wxArticleBean.getData().getDatas();
                if (isrefresh) {
                    smartrefreshlayout.finishRefresh();
                    adapterRight.setNewData(datas);
                } else {
                    adapterRight.addData(datas);
                    smartrefreshlayout.finishLoadMore();
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }

    private class ContentAdapter extends BaseQuickAdapter<WxArticleBean.DataBean.DatasBean, BaseViewHolder> {

        public ContentAdapter(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder holder, WxArticleBean.DataBean.DatasBean item) {
            if (item != null) {
                holder.setText(R.id.tv_title, item.getTitle());
                holder.setText(R.id.tv_time, "时间: " + item.getNiceDate());
            }

            holder.getView(R.id.rl_root).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("link", item.getLink());
                    startActivity(intent);
                }
            });

            ImageView like = holder.getView(R.id.iv_like);

            boolean isLogin = SPUtils.getInstance().getBoolean(Constants.LOGIN, false);

            if (!isLogin) {
                like.setSelected(false);
            } else {
                like.setSelected(item.isCollect());
            }

            like.setOnClickListener(v -> {
                if (!isLogin) {
                    Toast.makeText(mContext, "请先登录！", Toast.LENGTH_SHORT).show();
                } else {
                    if (!item.isCollect()) {
                        addCollect(holder, item);
                    } else {
                        unCollect(holder, item);
                    }
                }
            });

        }

        private void addCollect(BaseViewHolder holder, WxArticleBean.DataBean.DatasBean item) {
            //添加收藏
            String url = "http://www.wanandroid.com/lg/collect/" + item.getId() + "/json";
            OkGo.<String>post(url)
                    .tag("collect")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            Log.i(TAG, "onSuccess: " + body);
                            item.setCollect(true);
                            adapterRight.notifyItemChanged(holder.getLayoutPosition());
                        }

                        @Override
                        public void onFinish() {
                            super.onFinish();
                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);

                        }
                    });
        }
    }

    /**
     * 取消收藏
     *
     * @param holder
     * @param item
     */
    private void unCollect(BaseViewHolder holder, WxArticleBean.DataBean.DatasBean item) {
        //取消收藏
        String url = "http://www.wanandroid.com/lg/uncollect_originId/" + item.getId() + "/json";
        OkGo.<String>post(url)
                .tag("uncollect")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Log.i(TAG, "onSuccess: " + body);
                        item.setCollect(false);
                        adapterRight.notifyItemChanged(holder.getLayoutPosition());
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                    }
                });
    }
}
