package com.sx.dagger.component;

import com.sx.dagger.module.YiFragmentModule;
import com.sx.ui.fragment.YiFragment;

import dagger.Component;

/***       Author  shy
 *         Time   2018/6/25 0025    10:52      */
@Component(modules = YiFragmentModule.class)
public interface YiFragmentComponent {

    void in(YiFragment fragment);

}
