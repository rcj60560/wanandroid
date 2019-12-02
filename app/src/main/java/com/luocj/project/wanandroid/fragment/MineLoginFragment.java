package com.luocj.project.wanandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luocj.project.wanandroid.MainActivity;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.CollectBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.OKGO;
import com.luocj.project.wanandroid.utils.SPUtils;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class MineLoginFragment extends Fragment {

    private static final String TAG = MineLoginFragment.class.getSimpleName();
    private View inflate;
    private Context mContext;
    private RecyclerView recyclerview;
    private SmartRefreshLayout smartrefreshlayout;
    private int pageNum = 0;
    private CollectAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_mine_login, container, false);
        return inflate;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        inflate.findViewById(R.id.ttn_loginout).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SPUtils.putBoolean(getActivity(), Constants.LOGIN_SAVE, false);
//                ((MainActivity) mContext).changeTab(3);
//            }
//        });

        recyclerview = inflate.findViewById(R.id.recyclerview_collect);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        adapter = new CollectAdapter(R.layout.item_collect);
        recyclerview.setAdapter(adapter);

        smartrefreshlayout.autoRefresh();
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

    private void refresh(RefreshLayout refreshLayout, boolean b) {
        refreshLayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (b) {
                    smartrefreshlayout.setEnableLoadMore(false);
                    getCollectList();
                } else {
                    loadMore();
                }
            }
        }, 2000);
    }

    private void loadMore() {
        pageNum++;
        String collectUrl = "http://www.wanandroid.com/lg/collect/list/" + pageNum + "/json";
        OKGO.get(collectUrl, "loadmore", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);
                if (collectBean != null) {
                    if (collectBean.getErrorCode() == 0) {
                        if (collectBean.getData().getDatas().size() > 0) {
                            List<CollectBean.DataBean.DatasBean> datas = collectBean.getData().getDatas();
                            adapter.addData(datas);
                        } else {
                            View footer = View.inflate(getActivity(), R.layout.tixi_footer, null);
                            if (adapter.getFooterLayout() == null) {
                                adapter.setFooterView(footer);
                            }
                        }
                        smartrefreshlayout.finishLoadMore();
                        smartrefreshlayout.setEnableLoadMore(true);
                    } else {
                        showToast(collectBean.getErrorMsg());
                    }
                }
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


    private class CollectAdapter extends BaseQuickAdapter<CollectBean.DataBean.DatasBean, BaseViewHolder> {

        public CollectAdapter(int item_title) {
            super(item_title);
        }

        @Override
        protected void convert(BaseViewHolder holder, CollectBean.DataBean.DatasBean item) {
            holder.setText(R.id.tv_collect_title, item.getTitle());
            holder.setText(R.id.tv_collect_author, item.getAuthor());
            holder.setText(R.id.tv_collect_kind, item.getChapterName());
            holder.setText(R.id.tv_collect_nicedate, item.getNiceDate());
        }
    }

    private void getCollectList() {
        pageNum = 0;
        String collectUrl = "http://www.wanandroid.com/lg/collect/list/" + pageNum + "/json";
        OKGO.get(collectUrl, "collecturl", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);
                if (collectBean != null) {
                    if (collectBean.getErrorCode() == 0) {
                        List<CollectBean.DataBean.DatasBean> datas = collectBean.getData().getDatas();
                        adapter.setNewData(datas);
                        smartrefreshlayout.finishRefresh();
                        smartrefreshlayout.setEnableLoadMore(true);

                    } else {
                        showToast(collectBean.getErrorMsg());
                    }
                }
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

    private void showToast(String errorMsg) {
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
    }

}
