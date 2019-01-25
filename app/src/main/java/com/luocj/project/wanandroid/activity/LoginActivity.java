package com.luocj.project.wanandroid.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.luocj.project.wanandroid.MainActivity;
import com.luocj.project.wanandroid.R;
import com.luocj.project.wanandroid.bean.LoginBean;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private TextInputLayout tilAccount;
    private EditText edAccount;
    private TextInputLayout tilPassword;
    private EditText edPassword;
    private TextInputLayout tilRePassword;
    private EditText edRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        ImageView back = findViewById(R.id.iv_back);
        back.setOnClickListener(this);

        tilAccount = findViewById(R.id.til_account);
        edAccount = findViewById(R.id.et_account);

        tilPassword = findViewById(R.id.til_password);
        edPassword = findViewById(R.id.tiet_password);

        findViewById(R.id.btn_submit).setOnClickListener(this);
        findViewById(R.id.btn_skip).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                register();
                break;
            case R.id.btn_skip:
                go2Main();
                break;
        }
    }

    private void go2Main() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    private void register() {
        String account = tilAccount.getEditText().getText().toString().trim();
        String password = tilPassword.getEditText().getText().toString().trim();
        tilAccount.setErrorEnabled(false);
        tilPassword.setErrorEnabled(false);
        //验证用户名和密码
        if (validateAccount(account) && validatePassword(password)) {
            submit(account, password);
        }
    }

    private void submit(String account, String password) {
        String url = "http://www.wanandroid.com/user/login";
        OkGo.<String>post(url)
                .tag("register")
                .params("username", account)
                .params("password", password)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        LoginBean loginBean = JSONObject.parseObject(body, LoginBean.class);
                        int errorCode = loginBean.getErrorCode();
                        if (errorCode == 0) {
                            LoginBean.DataBean data = loginBean.getData();
                            data.setAvater("https://avatars3.githubusercontent.com/u/21009156?v=4");
                            SPUtils.getInstance().put(Constants.LOGIN, data.toString());
                            Log.i(TAG, "onSuccess: login" + SPUtils.getInstance().getString(Constants.LOGIN, "default"));
                            showToast("登录成功！");
                            go2Main();
                        } else {
                            showToast(loginBean.getErrorMsg());
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

    private void showToast(String error) {
        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    /**
     * 验证用户名
     *
     * @param account
     * @return
     */
    private boolean validateAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            showToast(tilAccount, "用户名不能为空");
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
            showToast(tilPassword, "密码不能为空");
            return false;
        }

        if (password.length() < 6 || password.length() > 18) {
            showToast(tilPassword, "密码长度为6-18位");
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
    private void showToast(TextInputLayout textInputLayout, String error) {
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }
}
