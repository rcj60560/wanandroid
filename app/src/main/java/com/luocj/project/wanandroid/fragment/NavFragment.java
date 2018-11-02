package com.luocj.project.wanandroid.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.luocj.project.wanandroid.MainActivity;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.activity.RegisterActivity;
import com.luocj.project.wanandroid.bean.RegisterBean;
import com.luocj.project.wanandroid.bean.UserBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.OKGO;
import com.luocj.project.wanandroid.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * 导航
 */

public class NavFragment extends Fragment {

    private static final String TAG = NavFragment.class.getSimpleName();
    private static final int REGISTER = 1001;
    private Context mContext;
    private View inflate;
    private EditText username;
    private TextInputLayout til;
    private TextInputLayout tilPsd;
    private TextInputEditText password;
    private RelativeLayout container;
    private TabLayout tablayout;
    private ViewPager viewpager;


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

    private void register() {
        Intent intent = new Intent(mContext, RegisterActivity.class);
        startActivityForResult(intent, NavFragment.REGISTER);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NavFragment.REGISTER) {
            if (resultCode == 101) {
                UserBean userinfo = (UserBean) data.getSerializableExtra(Constants.USERINFO);
                Log.i(TAG, "onActivityResult: " + userinfo.toString());
            } else {

            }
        }
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
                            SPUtils.getInstance().put(Constants.LOGIN,true);
//                            SPUtils.putBoolean(getActivity(), Constants.LOGIN, true);
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

    /**
     * 验证用户名
     *
     * @param account
     * @return
     */
    private boolean validateAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            showError(til, "用户名不能为空");
            return false;
        }
        return true;
    }

    /**
     * 验证密码
     *
     * @param password
     * @return
     */
    private boolean validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            showError(tilPsd, "密码不能为空");
            return false;
        }

        if (password.length() < 6 || password.length() > 18) {
            showError(tilPsd, "密码长度为6-18位");
            return false;
        }

        return true;
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
            return "position :" +position;
        }
    }
}
