package com.sx.dagger.component;

import com.sx.dagger.module.LoginModule;
import com.sx.ui.activity.LoginActivity;

import dagger.Component;

/***       Author  shy
 *         Time   2018/6/21 0021    16:03      */


@Component(modules = LoginModule.class)
public interface LoginComponent {

    void in(LoginActivity activity);

}


