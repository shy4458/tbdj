package com.sx.dagger.module;

import com.sx.presenter.SanPresenter;
import com.sx.ui.fragment.SanFragmetn;

import dagger.Module;
import dagger.Provides;

@Module
public class SanModule {

    SanFragmetn fragmetn;

    public SanModule(SanFragmetn fragmetn) {
        this.fragmetn = fragmetn;
    }

    @Provides
    SanPresenter providesSanPresenter (){
        return new SanPresenter(fragmetn);
    }

}
