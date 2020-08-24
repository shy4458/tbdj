package com.sx.dagger.module;

import com.sx.presenter.YiFragmentPresenter;
import com.sx.ui.fragment.YiFragment;

import dagger.Module;
import dagger.Provides;

/***       Author  shy
 *         Time   2018/6/25 0025    10:49      */

@Module
public class YiFragmentModule {

    YiFragment fragment;

    public YiFragmentModule(YiFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    YiFragmentPresenter pro(){
        return new YiFragmentPresenter(fragment);
    }
}
