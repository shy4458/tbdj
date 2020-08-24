package com.sx.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

/***       Author  shy
 *         Time   2018/6/21 0021    9:34      */

public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    private static Toast makeText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        initDagger();
        //设置布局
        setContentView(intiLayout());
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    protected abstract void initDagger();

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int intiLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 显示短toast
     *
     * @param context
     */
    public void toastShort(Context context, String text) {
        if (makeText==null) {
            makeText = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        makeText.setText(text);
        makeText.show();
    }
}
