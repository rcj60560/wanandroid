package com.luocj.project.wanandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.luocj.project.wanandroid.MainActivity;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.ProjectBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.OKGO;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目页面
 */

public class ProjectFragment extends Fragment {

    private static final String TAG = ProjectFragment.class.getSimpleName();
    private View inflate;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private Context mContext;
    private VPAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_project, container, false);
        return inflate;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(inflate);
        initData();
    }

    private void initData() {
        OKGO.get(Constants.PROJECT_TREE, "project", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                ProjectBean projectBean = JSONObject.parseObject(body, ProjectBean.class);
                if (projectBean.getErrorCode() == 0) {
                    Log.i(TAG, "onSuccess: ");
                    List<ProjectBean.DataBean> data = projectBean.getData();
                    ArrayList<TabFragment> tabFragments = new ArrayList<>();
                    ArrayList<String> titles = new ArrayList<>();
                    for (int i = 0; i < data.size(); i++) {
                        tabFragments.add(new TabFragment(data.get(i)));
                        titles.add(data.get(i).getName());
                    }
                    if (adapter == null) {
                        adapter = new VPAdapter(getChildFragmentManager(),tabFragments,titles);
                        viewpager.setAdapter(adapter);
                        tablayout.setupWithViewPager(viewpager,false);
                    }


                } else {
                    Log.i(TAG, "onSuccess: " + "failed");
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

    private void initView(View inflate) {
        tablayout = inflate.findViewById(R.id.tablayout);
        viewpager = inflate.findViewById(R.id.viewpager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        ArrayList<TabFragment> tabFragments = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            tabFragments.add(new TabFragment(i));
//        }
//        VPAdapter adapter = new VPAdapter(((MainActivity) mContext).getSupportFragmentManager(), tabFragments);
//        viewpager.setAdapter(adapter);
//        tablayout.setupWithViewPager(viewpager);

    }


    private class VPAdapter extends FragmentPagerAdapter {
        ArrayList<TabFragment> mFragments = new ArrayList<>();
        ArrayList<String> mTitles = new ArrayList<>();

        public VPAdapter(FragmentManager supportFragmentManager, ArrayList<TabFragment> tabFragments,ArrayList<String> data) {
            super(supportFragmentManager);
            this.mFragments = tabFragments;
            this.mTitles = data;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
}
