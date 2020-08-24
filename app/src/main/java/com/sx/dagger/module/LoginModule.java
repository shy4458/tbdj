package com.sx.dagger.module;

import com.sx.presenter.LoginPst;
import com.sx.ui.activity.LoginActivity;

import dagger.Module;
import dagger.Provides;

/***       Author  shy
 *         Time   2018/6/21 0021    16:00      */

@Module
public class LoginModule {

    LoginActivity activity;

    public LoginModule(LoginActivity activity) {
        this.activity = activity;
    }

    @Provides
    LoginPst pro(){
        return new LoginPst(activity);
    }
}
