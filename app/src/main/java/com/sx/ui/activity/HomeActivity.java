package com.sx.ui.activity;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sx.R;
import com.sx.ui.fragment.ErFragmetn;
import com.sx.ui.fragment.SanFragmetn;
import com.sx.ui.fragment.SiFragment;
import com.sx.ui.fragment.YiFragment;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

/***       Author  shy
 *         Time   2018/6/21 0021    16:41      */

public class HomeActivity extends BaseActivity {

    static int i = 0;
    private RadioGroup rg;
    private FrameLayout fl;
    private RadioButton rb1, rb2, rb3, rb4;
    private YiFragment yiFragment;
    private ErFragmetn erFragmetn;
    private SanFragmetn sanFragmetn;
    private SiFragment siFragment;

    @Override
    protected void initDagger() {

    }

    @Override
    public int intiLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        rg = findViewById(R.id.homeRg);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        fl = findViewById(R.id.homeF);
        initListener();
        setTabSelection(0);
    }

    @Override
    public void initData() {

    }

    private void initListener() {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.e("/////",  "" +checkedId);
                switch (checkedId) {
                    case R.id.rb1:
                        Log.e("/////",  "rb1");
                        setTabSelection(0);
                        ObjectAnimator translateX = ObjectAnimator.ofFloat(rb1, "scaleX", 0.8f, 0.6f, 0.8f);
                        ObjectAnimator translateY = ObjectAnimator.ofFloat(rb1, "scaleY", 0.8f, 0.6f, 0.8f);

                        translateX.setInterpolator(new CycleInterpolator(1));
                        translateX.setDuration(1000);
                        translateX.start();

                        translateY.setInterpolator(new CycleInterpolator(1));
                        translateY.setDuration(1000);
                        translateY.start();

                        break;
                    case R.id.rb2:
                        setTabSelection(1);
                        break;
                    case R.id.rb3:
                        setTabSelection(2);
                        break;
                    case R.id.rb4:
                        setTabSelection(3);
                        break;
                }
            }
        });
        rg.clearCheck();
    }

    public void setTabSelection(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                rb1.setChecked(true);
                if (yiFragment == null) {
                    yiFragment = new YiFragment();
                    transaction.add(R.id.homeF, yiFragment, "yiFragment");
                } else {
                    transaction.show(yiFragment);
                }
                break;
            case 1:
                rb2.setChecked(true);
                if (erFragmetn == null) {
                    erFragmetn = new ErFragmetn();
                    transaction.add(R.id.homeF, erFragmetn, "erFragmetn");
                } else {
                    transaction.show(erFragmetn);
                }
                break;

            case 2:
                rb3.setChecked(true);
                if (sanFragmetn == null) {
                    sanFragmetn = new SanFragmetn();
                    transaction.add(R.id.homeF, sanFragmetn, "sanFragmetn");
                } else {
                    transaction.show(sanFragmetn);
                }
                break;
            case 3:
                rb4.setChecked(true);
                if (siFragment == null) {
                    siFragment = new SiFragment();
                    transaction.add(R.id.homeF, siFragment, "siFragment");
                } else {
                    transaction.show(siFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (yiFragment != null)
            transaction.hide(yiFragment);
        if (erFragmetn != null)
            transaction.hide(erFragmetn);
        if (sanFragmetn != null)
            transaction.hide(sanFragmetn);
        if (siFragment != null)
            transaction.hide(siFragment);
        transaction.commit();
    }
}
