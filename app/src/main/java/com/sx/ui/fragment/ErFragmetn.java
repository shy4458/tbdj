package com.sx.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.sx.R;
import com.sx.ui.adapter.ErFragmentAdapter;
import com.sx.ui.fragment.erFragment.ErFragmentContent;

import java.util.ArrayList;

/***       Author  shy
 *         Time   2018/6/21 0021    16:59      */

public class ErFragmetn extends BaseFragment {


    private TabLayout tab;
    private ImageView iv_ss;
    private ViewPager vp;

    @Override
    protected void initDagger() {

    }

    @Override
    public int intiLayout() {
        return R.layout.fragment_er;
    }

    @Override
    public void initView(View view,Bundle savedInstanceState) {
        tab = view.findViewById(R.id.er_fragment_tab);
        iv_ss = view.findViewById(R.id.er_fragment_iv_ss);
        vp = view.findViewById(R.id.er_fragment_vp);

        ArrayList<String> title = new ArrayList<>();
        title.add("推荐");
        title.add("小视频");
        title.add("榜单");
        title.add("超级IP季");
        title.add("播单");
        title.add("搞笑");
        title.add("综艺");
        title.add("游戏");
        title.add("音乐");
        title.add("现场");
        title.add("黑科技");
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < title.size(); i++) {
            fragments.add(newInstance(title.get(i)));
        }
        vp.setAdapter(new ErFragmentAdapter(getFragmentManager(),getActivity(),title,fragments));
        tab.setupWithViewPager(vp);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initData() {

    }
    public static ErFragmentContent newInstance(String grouping_lx) {
        ErFragmentContent fragment = new ErFragmentContent();
        Bundle bundle = new Bundle();
        bundle.putString("grouping_lx", grouping_lx);
        fragment.setArguments(bundle);
        return fragment;
    }

}
