package com.luocj.project.wanandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.adapter.TiXiAdapter;
import com.luocj.project.wanandroid.bean.TiXiBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 体系
 */

public class TiXiFragment extends Fragment {

    private Context mContext;
    private View inflate;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView recyclerview;
    private TiXiAdapter adapter;
    private View footer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_tixi, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        LinearLayout rootview = inflate.findViewById(R.id.rootview);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        recyclerview = inflate.findViewById(R.id.recyclerview_tixi);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerview.setLayoutManager(linearLayoutManager);
        adapter = new TiXiAdapter(R.layout.item_tixi, null);
        recyclerview.setAdapter(adapter);
        footer = View.inflate(getActivity(), R.layout.tixi_footer, null);

        smartrefreshlayout.autoRefresh();
        smartrefreshlayout.setEnableLoadMore(false);
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refresh(refreshLayout);
            }
        });

        adapter.setEmptyView(R.layout.empty_view,rootview);
    }

    private void refresh(RefreshLayout refreshLayout) {
        refreshLayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                getTixiData();
            }
        }, 2000);
    }

    private void getTixiData() {
        String url = "http://www.wanandroid.com/tree/json";
        OkGo.<String>get(url)
                .tag("tixi")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        TiXiBean tiXiBean = com.alibaba.fastjson.JSONObject.parseObject(response.body(), TiXiBean.class);
                        List<TiXiBean.DataBean> data = tiXiBean.getData();
                        adapter.setNewData(data);
                        smartrefreshlayout.finishRefresh();

                        LinearLayout footerLayout = adapter.getFooterLayout();
                        if (footerLayout == null) {
                            adapter.setFooterView(footer);
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


    @Override
    public void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelAll();
    }
}
