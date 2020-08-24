package com.sx.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sx.R;

/***       Author  shy
 *         Time   2018/6/21 0021    17:01      */

public abstract class BaseFragment extends Fragment{

    protected abstract void initDagger();

    public abstract int intiLayout();

    public abstract void initView(View view,Bundle savedInstanceState);

    public abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(intiLayout(), container,false);
        setHasOptionsMenu(true); //toobar menu显示出来
        initDagger();
        initView(view,savedInstanceState);
        initData();
        return view;
    }
}
