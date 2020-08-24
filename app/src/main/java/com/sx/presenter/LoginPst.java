package com.sx.presenter;

import com.google.gson.Gson;
import com.sx.framework.BaseApplication;
import com.sx.model.LoginBean;
import com.sx.ui.activity.LoginActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;

/***       Author  shy
 *         Time   2018/6/21 0021    15:59      */

public class LoginPst extends BasePresenter{

    LoginActivity activity;
    public LoginPst(LoginActivity activity) {
        this.activity = activity;
    }

    public void login(String user, String pwd){
        Call<ResponseBody> login = retrofit2Service.login(user, pwd);
        login.enqueue(new CallbackAdapter());
    }

    @Override
    protected void failed(String msg) {
        activity.toastShort(activity,msg);
    }

    @Override
    protected void parserData(String data) {
        LoginBean loginBean = new Gson().fromJson(data, LoginBean.class);
        if (loginBean.getCode() == 1) {
            BaseApplication.set("user_id", loginBean.getData().getUserId());
            activity.yLogin();
        }
    }
}
