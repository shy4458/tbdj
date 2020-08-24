package com.sx.dagger.module;

import com.sx.presenter.ErFragmentTuijianPresenter;
import com.sx.ui.fragment.erFragment.ErFragmentContent;

import dagger.Module;
import dagger.Provides;

@Module
public class ErFragmentTuijianModule {

    ErFragmentContent fragmentContent;

    public ErFragmentTuijianModule(ErFragmentContent fragmentContent) {
        this.fragmentContent = fragmentContent;
    }

    @Provides
    ErFragmentTuijianPresenter providesErFragmentTuijianPresenter(){
        return new ErFragmentTuijianPresenter(fragmentContent);
    }
}
