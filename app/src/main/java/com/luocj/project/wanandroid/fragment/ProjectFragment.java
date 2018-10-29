package com.luocj.project.wanandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.luocj.project.wanandroid.MainActivity;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.ProjectBean;
import com.luocj.project.wanandroid.utils.OKGO;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目页面
 */

public class ProjectFragment extends Fragment {

    private static final String TAG = ProjectFragment.class.getSimpleName();
    private Context mContext;
    private View inflate;
    private TagFlowLayout tfl;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private VPadapter vpAdapter;

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

        tablayout = inflate.findViewById(R.id.tablayout);
        viewpager = inflate.findViewById(R.id.viewpager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        String url = "http://www.wanandroid.com/project/tree/json";
        OKGO.get(url, "projectfragment", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                ProjectBean projectBean = JSONObject.parseObject(response.body(), ProjectBean.class);
                if (projectBean != null) {
                    List<ProjectBean.DataBean> data = projectBean.getData();
                    vpAdapter = new VPadapter(((MainActivity) mContext).getSupportFragmentManager(), data);
                    viewpager.setAdapter(vpAdapter);
                    tablayout.setupWithViewPager(viewpager);
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


    /**
     * 设置流式布局
     *
     * @param mVals
     */

    private void setTabFlowLayout(ArrayList<String> mVals) {
//        tfl.setAdapter(new TagAdapter<String>(mVals) {
//            @Override
//            public View getView(FlowLayout parent, int position, String s) {
//                if (mVals != null) {
//                    TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tfl_project, tfl, false);
//                    tv.setText(s);
//                    return tv;
//                }
//                return null;
//            }
//        });
    }

//    private void initView(View inflate) {
//        tfl = inflate.findViewById(R.id.tfl_project);
//        tfl.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
//            @Override
//            public boolean onTagClick(View view, int position, FlowLayout parent) {
//                Log.i(TAG, "onTagClick: " + position);
//                return false;
//            }
//        });
//    }

    private class VPadapter extends FragmentStatePagerAdapter {
        private List<ProjectBean.DataBean> mDatas = new ArrayList<>();

        public VPadapter(FragmentManager fm, List<ProjectBean.DataBean> datas) {
            super(fm);
            this.mDatas = datas;
        }

        @Override
        public Fragment getItem(int position) {
            return TabFragment.getInstance(mDatas.get(position).getId()+"");
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mDatas.get(position).getName();
        }
    }


}
