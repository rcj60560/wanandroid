package com.luocj.project.wanandroid.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSONObject;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.activity.WebViewActivity;
import com.luocj.project.wanandroid.adapter.HomeAdapter;
import com.luocj.project.wanandroid.bean.BannerBean;
import com.luocj.project.wanandroid.bean.HomeDetailBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.DialogUtils;
import com.luocj.project.wanandroid.utils.GlideImageLoader;
import com.luocj.project.wanandroid.widget.dialog.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private Context mContext;
    private List<String> titles;
    private int pageNum = 0;
    private Banner banner;
    private Banner bannerLayout;
    private View inflate;
    private View headerBanner;
    private SmartRefreshLayout smartFreshLayout;
    private HomeAdapter homeAdapter;
    private LinearLayout rootview;
    private RelativeLayout emptyview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(inflate);
    }

    private void initView(View inflate) {
        ClassicsHeader header = inflate.findViewById(R.id.header_home);
        RecyclerView recyclerviewHome = inflate.findViewById(R.id.recyclerview_home);
        emptyview = inflate.findViewById(R.id.rl_empty);

        rootview = inflate.findViewById(R.id.rootview);
        smartFreshLayout = inflate.findViewById(R.id.smartrefreshlayout);
        smartFreshLayout.autoRefresh();
        smartFreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refresh(refreshLayout, false);
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refresh(refreshLayout, true);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerviewHome.setLayoutManager(linearLayoutManager);
        homeAdapter = new HomeAdapter(getActivity(), R.layout.item_home, null);
        headerBanner = LayoutInflater.from(mContext).inflate(R.layout.header_banner, smartFreshLayout, false);
        homeAdapter.addHeaderView(headerBanner);
        recyclerviewHome.setAdapter(homeAdapter);

    }

    private void setBanner(View view, ArrayList<String> images, List<String> data, List<BannerBean.DataBean> dataBeans) {
        bannerLayout = view.findViewById(R.id.banner);
        banner = bannerLayout.setImages(images).setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
//        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setBannerTitles(data);
        banner.start();

        banner.setOnBannerListener(position -> {
            switch (position) {
//                    case 0:
//                        startActivity(new Intent(mContext, PublicActivity.class));
//                        break;
                default:
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("link", dataBeans.get(position).getUrl());
                    startActivity(intent);
                    break;
            }

        });

    }

    private void refresh(RefreshLayout refreshlayout, final boolean isFresh) {

        DialogUtils.showDialog(R.layout.dialog_loading,
                (int) (Utils.getScreenWidth(mContext) * 0.8),
                null,
                getFragmentManager());

        refreshlayout.getLayout().postDelayed(() -> {
            if (isFresh) {
                getBanner();
                getHomeData();
            } else {
                getMoreHomeData();
            }
        }, 2000);
    }

    private void getBanner() {
        titles = new ArrayList<>();
        ArrayList<String> images = new ArrayList<>();
        String banner = "http://www.wanandroid.com/banner/json";
        OkGo.<String>get(banner)
                .tag("banner")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        BannerBean bean = JSONObject.parseObject(response.body(), BannerBean.class);
                        List<BannerBean.DataBean> data = bean.getData();
                        for (int i = 0; i < data.size(); i++) {
                            titles.add(data.get(i).getTitle());
                            images.add(data.get(i).getImagePath());
                        }
                        setBanner(headerBanner, images, titles, data);
                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                    }
                });

    }


    private void getMoreHomeData() {
        pageNum++;
        String url = "http://www.wanandroid.com/article/list/" + pageNum + "/json";
        OkGo.<String>get(url)
                .tag("home1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        HomeDetailBean homeDetailBean = JSONObject.parseObject(response.body(), HomeDetailBean.class);
                        homeAdapter.addData(homeDetailBean.getData().getDatas());
                        smartFreshLayout.finishLoadmore();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        Log.i(TAG, "onError: " + response.toString());
                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }

    public void getHomeData() {
        String url = "http://www.wanandroid.com/article/list/" + 0 + "/json";
        OkGo.<String>get(url)
                .tag("home")
                .execute(new StringCallback() {

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        HomeDetailBean homeDetailBean = JSONObject.parseObject(response.body(), HomeDetailBean.class);
                        if (homeDetailBean.getErrorCode() == 0) {
                            homeAdapter.setNewData(homeDetailBean.getData().getDatas());
                            smartFreshLayout.finishRefresh();
                        } else {
                            emptyview.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        Log.i(TAG, "onError: " + response.toString());
                        emptyview.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFinish() {
                        DialogUtils.dissmiss();
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelAll();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (banner != null) {
            banner.startAutoPlay();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }

}
