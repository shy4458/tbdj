package com.sx.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ErFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private ArrayList<String> title;
    private ArrayList<Fragment> fragments;

    public ErFragmentAdapter(FragmentManager fm, Context context, ArrayList<String> title, ArrayList<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.title = title;
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
