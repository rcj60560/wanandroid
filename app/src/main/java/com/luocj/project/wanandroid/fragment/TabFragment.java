package com.luocj.project.wanandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.adapter.ProjectAdapter;
import com.luocj.project.wanandroid.bean.ProjectListBean;
import com.luocj.project.wanandroid.utils.OKGO;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class TabFragment extends BaseFragment {

    private static final String TAG = TabFragment.class.getSimpleName();
    private Context mContext;
    private View inflate;
    private RecyclerView rv;
    private SmartRefreshLayout smartRefreshLayout;
    private RecyclerView recyclerView;
    private ProjectAdapter adapter;
    private String cId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_tab_fragment, container, false);
        return inflate;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(inflate);
    }

    @Override
    protected void loadData() {
        Log.i(TAG, "loadData: " + "加载数据" + cId);
    }


    private void initView(View inflate) {
        smartRefreshLayout = inflate.findViewById(R.id.smartrefreshlayout);
        recyclerView = inflate.findViewById(R.id.recyclerview_project);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ProjectAdapter(R.layout.item_home);
        recyclerView.setAdapter(adapter);

        smartRefreshLayout.autoRefresh();
        smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
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

    private void refresh(RefreshLayout refreshLayout, boolean b) {
        refreshLayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (b) {
                    smartRefreshLayout.setEnableLoadMore(false);
                    getList(cId);
                } else {

                }
            }
        }, 2000);
    }


    @Override
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        if (arguments != null) {
            cId = arguments.getString("cId", "");
//            getList(cId);
        }
    }

    private void getList(String cId) {
        String url = "http://www.wanandroid.com/project/list/1/json?cid=" + cId;
        OKGO.get(url, "url", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                ProjectListBean projectListBean = JSONObject.parseObject(response.body(), ProjectListBean.class);
                if (projectListBean.getErrorCode() == 0) {
                    List<ProjectListBean.DataBean.DatasBean> datas = projectListBean.getData().getDatas();
                    adapter.addData(datas);
                    smartRefreshLayout.finishRefresh();
                    smartRefreshLayout.setEnableLoadMore(true);

                } else {
                    Toast.makeText(getActivity(), projectListBean.getErrorMsg(), Toast.LENGTH_SHORT).show();
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

    public static TabFragment getInstance(String msg) {
        Bundle bundle = new Bundle();
        bundle.putString("cId", msg);

        TabFragment fm = new TabFragment();
        fm.setArguments(bundle);
        return fm;
    }

}
