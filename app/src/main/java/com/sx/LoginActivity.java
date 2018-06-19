package com.sx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/***       Author  shy
 *         Time   2018/6/19 0019    9:29      */

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText name;
    private TextInputEditText pwd;
    private Button login;
    private LinearLayout llLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();
    }

    private void initListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(name.getText().toString())){
                    if (!"".equals(pwd.getText().toString())){
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        finish();
                    }else {
                        pwd.setError("请输入密码");
                    }
                }else {
                    name.setError("请输入用户名");
                }
            }
        });
    }

    private void initView() {
        name = findViewById(R.id.et_name);
        pwd = findViewById(R.id.et_pwd);
        login = findViewById(R.id.bLogin);
        llLogin = findViewById(R.id.ll_login);
        llLogin.getBackground().setAlpha(150);
    }
}
