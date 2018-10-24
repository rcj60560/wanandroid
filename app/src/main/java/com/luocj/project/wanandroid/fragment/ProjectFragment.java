package com.luocj.project.wanandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.ProjectBean;
import com.luocj.project.wanandroid.utils.OKGO;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        return inflate;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(inflate);
        initData();
    }

    private void initData() {
        String url = "http://www.wanandroid.com/project/tree/json";
        OKGO.get(url, "tag", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                ArrayList<String> mVals = new ArrayList<>();
                ProjectBean projectBean = JSONObject.parseObject(response.body(), ProjectBean.class);
                if (projectBean != null) {
                    List<ProjectBean.DataBean> data = projectBean.getData();
                    if (data != null) {
                        for (int i = 0; i < data.size(); i++) {
                            mVals.add(data.get(i).getName());
                        }
                    }

                }

                setTabFlowLayout(mVals);

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
        tfl.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                if (mVals != null) {
                    TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tfl_project, tfl, false);
                    tv.setText(s);
                    return tv;
                }
                return null;
            }
        });
    }

    private void initView(View inflate) {
        tfl = inflate.findViewById(R.id.tfl_project);
        tfl.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Log.i(TAG, "onTagClick: " + position);
                return false;
            }
        });
    }


}
