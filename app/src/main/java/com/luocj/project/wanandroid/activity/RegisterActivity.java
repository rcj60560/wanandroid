package com.luocj.project.wanandroid.activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.RegisterBean;
import com.luocj.project.wanandroid.bean.UserBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getSimpleName();
    private TextInputLayout tilAccount;
    private EditText edAccount;
    private TextInputLayout tilPassword;
    private EditText edPassword;
    private TextInputLayout tilRePassword;
    private EditText edRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        tilAccount = findViewById(R.id.til_account);
        edAccount = findViewById(R.id.et_account);

        tilPassword = findViewById(R.id.til_password);
        edPassword = findViewById(R.id.tiet_password);

        tilRePassword = findViewById(R.id.til_repassword);
        edRePassword = findViewById(R.id.tiet_repassword);

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = tilAccount.getEditText().getText().toString().trim();
                String password = tilPassword.getEditText().getText().toString().trim();
                String rePassword = tilRePassword.getEditText().getText().toString().trim();
                tilAccount.setErrorEnabled(false);
                tilPassword.setErrorEnabled(false);
                //验证用户名和密码
                if (validateAccount(account) && validatePassword(password) && validateRePassword(rePassword)) {
                    register(account, password, rePassword);
                }
            }
        });

    }


    /**
     * 注册账号
     *
     * @param account
     * @param password
     * @param rePassword
     */
    private void register(String account, String password, String rePassword) {
        Log.i(TAG, "register: " + "开始注册");
        String url = "http://www.wanandroid.com/user/register";
        OkGo.<String>post(url)
                .tag("register")
                .params("username", account)
                .params("password", password)
                .params("repassword", rePassword)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        RegisterBean registerBean = JSONObject.parseObject(body, RegisterBean.class);
                        if (registerBean.getErrorCode() == 0) {
                            showError("注册成功");
                            UserBean userBean = new UserBean();
                            userBean.setUsername(registerBean.getData().getUsername());
                            userBean.setPassword(registerBean.getData().getPassword());
                            userBean.setToken(registerBean.getData().getToken());
                            userBean.setEmail(registerBean.getData().getEmail());
                            userBean.setId(registerBean.getData().getId());
                            SPUtils.putString(RegisterActivity.this, Constants.USERINFO, userBean.toString());

                            Intent intent = new Intent();
                            intent.putExtra(Constants.USERINFO,userBean);
                            setResult(101,intent);
                            finish();

                        } else {
                            showError(registerBean.getErrorMsg());
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

    private void showError(String errorMsg) {
        Toast.makeText(RegisterActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
    }


    /**
     * 验证用户名
     *
     * @param account
     * @return
     */
    private boolean validateAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            showError(tilAccount, "用户名不能为空");
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
            showError(tilPassword, "密码不能为空");
            return false;
        }

        if (password.length() < 6 || password.length() > 18) {
            showError(tilPassword, "密码长度为6-18位");
            return false;
        }

        return true;
    }


    /**
     * 验证密码
     *
     * @param rePassword
     * @return
     */
    private boolean validateRePassword(String rePassword) {

        if (TextUtils.isEmpty(rePassword)) {
            showError(tilPassword, "密码不能为空");
            return false;
        }

        if (rePassword.length() < 6 || rePassword.length() > 18) {
            showError(tilPassword, "密码长度为6-18位");
            return false;
        }

        if (!TextUtils.equals(rePassword, rePassword)) {
            showError(tilRePassword, "两次密码不相同");
            return false;
        }
        return true;

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
}
