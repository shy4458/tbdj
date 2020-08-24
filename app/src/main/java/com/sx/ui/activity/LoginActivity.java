package com.sx.ui.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sx.R;

import com.sx.dagger.component.DaggerLoginComponent;
import com.sx.dagger.module.LoginModule;
import com.sx.presenter.LoginPst;

import javax.inject.Inject;

/***       Author  shy
 *         Time   2018/6/19 0019    9:29      */

public class LoginActivity extends BaseActivity {

    @Inject
    LoginPst pst;

    private TextInputEditText name;
    private TextInputEditText pwd;
    private Button login;
    private LinearLayout llLogin;

    @Override
    protected void initDagger() {
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().in(this);
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        name = findViewById(R.id.et_name);
        pwd = findViewById(R.id.et_pwd);
        login = findViewById(R.id.bLogin);
        llLogin = findViewById(R.id.ll_login);
        llLogin.getBackground().setAlpha(150);
        initListener();
    }

    @Override
    public void initData() {

    }

    private void initListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!"".equals(name.getText().toString())) {
//                    if (!"".equals(pwd.getText().toString())) {
//                        pst.login(name.getText().toString(), pwd.getText().toString());
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
//                    } else {
//                        pwd.setError("请输入密码");
//                    }
//                } else {
//                    name.setError("请输入用户名");
//                }
            }
        });
    }

    public void yLogin() {
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        finish();
    }
}
