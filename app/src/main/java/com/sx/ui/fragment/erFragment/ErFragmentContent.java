package com.sx.ui.fragment.erFragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sx.R;
import com.sx.dagger.component.DaggerErFragmentTuijianComponent;
import com.sx.dagger.module.ErFragmentTuijianModule;
import com.sx.model.erFragmentModel.RecommendBean;
import com.sx.presenter.ErFragmentTuijianPresenter;
import com.sx.ui.adapter.ErFragmentContentAdapter;
import com.sx.ui.fragment.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

public class ErFragmentContent  extends BaseFragment{

    @Inject
    ErFragmentTuijianPresenter presenter;
    private String grouping_lx;
    private RecyclerView rv;

    @Override
    protected void initDagger() {
        DaggerErFragmentTuijianComponent.builder().erFragmentTuijianModule(new ErFragmentTuijianModule(this)).build().in(this);
    }

    @Override
    public int intiLayout() {
        return R.layout.re_fragment_content;
    }

    @Override
    public void initView(View view,Bundle savedInstanceState) {
        rv = view.findViewById(R.id.er_fragment_rv);
        Bundle bundle = getArguments();
        grouping_lx = bundle.getString("grouping_lx");

    }

    @Override
    public void initData() {
        presenter.video();
    }

    public void getDate(RecommendBean recommendBean) {
        ErFragmentContentAdapter erFragmentContentAdapter = new ErFragmentContentAdapter(getActivity(),recommendBean);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(erFragmentContentAdapter);
    }
}
