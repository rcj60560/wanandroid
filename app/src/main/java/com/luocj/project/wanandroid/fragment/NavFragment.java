package com.luocj.project.wanandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luocj.project.wanandroid.MainActivity;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.adapter.LeftAdapter;
import com.luocj.project.wanandroid.adapter.RightAdapter;
import com.luocj.project.wanandroid.bean.NavigationBean;
import com.luocj.project.wanandroid.bean.RegisterBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.OKGO;
import com.luocj.project.wanandroid.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航
 */

public class NavFragment extends Fragment {

    private static final String TAG = NavFragment.class.getSimpleName();
    private static final int REGISTER = 1001;
    private Context mContext;
    private View inflate;
    private RecyclerView rv1;
    private RecyclerView rv2;
    private LeftAdapter leftAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_navi, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv1 = inflate.findViewById(R.id.recyclervie_left);
        rv1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));


        rv2 = inflate.findViewById(R.id.recyclervie_right);
        rv2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

//        container = inflate.findViewById(R.id.rl_mine_container);
//        til = inflate.findViewById(R.id.til_account);
//        username = inflate.findViewById(R.id.et_account);
//
//        tilPsd = inflate.findViewById(R.id.til_password);
//        password = inflate.findViewById(R.id.tiet_password);
//
//        inflate.findViewById(R.id.btn_login).setOnClickListener(v -> {
//            String account = til.getEditText().getText().toString().trim();
//            String password = tilPsd.getEditText().getText().toString().trim();
//            til.setErrorEnabled(false);
//            tilPsd.setErrorEnabled(false);
//            //验证用户名和密码
//            if (validateAccount(account) && validatePassword(password)) {
//                login(account, password);
//            }
//        });
//
//        inflate.findViewById(R.id.btn_regist).setOnClickListener(v -> {
//            //注册
//            register();
//        });
    }

    private void loginOut() {
        ((MainActivity) mContext).changeTab(3);
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     */
    private void login(String username, String password) {
        String url = "http://www.wanandroid.com/user/login";
        OkGo.<String>post(url)
                .tag("login")
                .params("username", username)
                .params("password", password)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        RegisterBean userBean = JSONObject.parseObject(response.body(), RegisterBean.class);
                        if (userBean.getErrorCode() == 0) {
                            showToast("登录成功！");
                            Log.i(TAG, "onSuccess: userName :----------->" + userBean.getData().getUsername());
//                            getCollectList();
                            SPUtils.getInstance().put(Constants.LOGIN_SAVE, true);
//                            SPUtils.putBoolean(getActivity(), Constants.LOGIN_SAVE, true);
                            switchFragment();
                        } else {
                            showToast(userBean.getErrorMsg());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Log.i(TAG, "onError: ");
                        showToast(response.body());
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        Log.i(TAG, "onFinish: ");
                    }
                });
    }

    private void switchFragment() {
        ((MainActivity) mContext).changeTab(4);
    }


    private void showToast(String body) {
        Toast.makeText(getActivity(), body + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        OKGO.get(Constants.NAVIURL, "navifragment", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                NavigationBean resultBean = JSONObject.parseObject(response.body(), NavigationBean.class);
                int errorCode = resultBean.getErrorCode();
                if (errorCode == 0) {

                    List<NavigationBean.DataBean> data = resultBean.getData();
                    ArrayList<Boolean> booleans = new ArrayList<>();
                    booleans.add(true);
                    for (int i = 1; i < data.size(); i++) {
                        booleans.add(false);
                    }
                    leftAdapter = new LeftAdapter(R.layout.item_text);
                    rv1.setAdapter(leftAdapter);
                    leftAdapter.setNewData(data);
                    leftAdapter.setSelect(booleans);
                    leftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            setSelected(adapter, position);
                            RightAdapter rightAdapter = new RightAdapter(R.layout.item_tixi);
                            rv2.setAdapter(rightAdapter);
                            if (data!=null){
                                rightAdapter.setNewData(data);
                            }
                        }
                    });

                } else {
                    showToast(resultBean.getErrorMsg());
                }
            }

            private void setSelected(BaseQuickAdapter adapter, int position) {
                for (int i = 0; i < adapter.getData().size(); i++) {
                    if (i==position){
                        leftAdapter.getSelected().set(i,true);
                    }else {
                        leftAdapter.getSelected().set(i,false);
                    }
                    leftAdapter.notifyDataSetChanged();
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
    }

    /**
     * 显示错误提示，并获取焦点
     *
     * @param textInputLayout
     * @param error
     */
    private void showError(TextInputLayout textInputLayout, String error) {
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }

    private class VPadapter extends FragmentStatePagerAdapter {
        public VPadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "position :" + position;
        }
    }
}
