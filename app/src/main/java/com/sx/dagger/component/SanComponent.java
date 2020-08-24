package com.sx.dagger.component;

import com.sx.dagger.module.SanModule;
import com.sx.ui.fragment.SanFragmetn;

import dagger.Component;

@Component(modules = SanModule.class)
public interface SanComponent {

    void in(SanFragmetn fragmetn);

}
