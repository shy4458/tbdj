package com.sx.dagger.component;

import com.sx.dagger.module.ErFragmentTuijianModule;
import com.sx.ui.fragment.erFragment.ErFragmentContent;

import dagger.Component;

@Component(modules = ErFragmentTuijianModule.class)
public interface ErFragmentTuijianComponent {

    void in(ErFragmentContent fragmentContent);

}
