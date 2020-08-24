package com.sx.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ddz.floatingactionbutton.FloatingActionMenu;
import com.squareup.picasso.Picasso;
import com.sx.R;
import com.sx.dagger.component.DaggerYiFragmentComponent;
import com.sx.dagger.module.YiFragmentModule;
import com.sx.model.CurrentWeather;
import com.sx.presenter.EventBusMessage;
import com.sx.presenter.YiFragmentPresenter;
import com.sx.ui.activity.BaseActivity;
import com.sx.ui.activity.Fab1Activity;
import com.sx.ui.activity.Fab2Activity;
import com.sx.ui.activity.ZhongActivity;
import com.sx.ui.adapter.RvAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

/***       Author  shy
 *         Time   2018/6/21 0021    16:58      */

public class YiFragment extends BaseFragment implements RvAdapter.OnItemClickListener, View.OnClickListener {

    @Inject
    YiFragmentPresenter presenter;

    private RecyclerView recyclerView;
    private ImageView ivBj;
    private Toolbar toolbar;
    private RvAdapter rvAdapter;


    @Override
    protected void initDagger() {
        DaggerYiFragmentComponent.builder().yiFragmentModule(new YiFragmentModule(this)).build().in(this);
    }

    @Override
    public int intiLayout() {
        return R.layout.fagment_yi;
    }

    @Override
    public void initView(View view,Bundle savedInstanceState) {
        toolbar = view.findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingtoolbarlayout = view.findViewById(R.id.collapsingtoolbarlayout);
        ivBj = view.findViewById(R.id.iv_bj);
        recyclerView = view.findViewById(R.id.main_rv);
        FloatingActionMenu floatingActionMenu = view.findViewById(R.id.floatingActionMenu);
        FloatingActionButton fab1 = view.findViewById(R.id.fab1);
        FloatingActionButton fab2 = view.findViewById(R.id.fab2);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
//        toolbar.setTitle("title");
//        toolbar.setTitleTextColor(Color.RED);
//        toolbar.setSubtitle("Sub title");
//        toolbar.setSubtitleTextColor(Color.parseColor("#80ff0000"));
//        toolbar.setNavigationIcon(R.mipmap.ic_back);
        BaseActivity activity = (BaseActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        collapsingtoolbarlayout.setTitle("天气呀");

        collapsingtoolbarlayout.setExpandedTitleColor(Color.GRAY);
        collapsingtoolbarlayout.setExpandedTitleColor(Color.RED);

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "返回", Toast.LENGTH_SHORT).show();
//            }
//        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_item1:
                        rvAdapter.addData(0);
                        recyclerView.scrollToPosition(0);
                        return true;
                    case R.id.action_item2:
                        rvAdapter.removeData(0);
                        return true;

                    case R.id.action_item3:
                        startActivity(new Intent(getActivity(), ZhongActivity.class));
                        return true;
                }
                return false;
            }
        });
        initRV();
    }

    @Override
    public void initData() {
//        presenter.weather();
            presenter.simulationData();
    }

    //如果有Menu,创建完后,系统会自动添加到ToolBar上
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.toolbar_menu, menu);
    }

    private void initRV() {
        //添加分割线
        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        decoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.rv_decoration));
        recyclerView.addItemDecoration(decoration);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    public void yWeather(List<CurrentWeather> weather) {
        rvAdapter = new RvAdapter(getActivity(), weather);
        rvAdapter.setItemClickListener(this);
        recyclerView.setAdapter(rvAdapter);
//        Picasso.with(getActivity()).load("https://ali.image.hellorf.com/images/5d553fc246e183577ac1a493054dbabe.jpeg").into(ivBj);
        ivBj.setImageResource(R.mipmap.guanggao);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000);
        defaultItemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(defaultItemAnimator);

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        Log.e("/////", v.getId() + "");
        switch (v.getId()){
            case R.id.fab1:
                startActivity(new Intent(getActivity(), Fab1Activity.class));
                break;

            case R.id.fab2:
                startActivity(new Intent(getActivity(), Fab2Activity.class));
                break;
        }
    }
}
