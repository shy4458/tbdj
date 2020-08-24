package com.sx.ui.myView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import com.sx.presenter.MyTypeEvaluator;
import com.sx.presenter.Test;

public class MyViewTest extends View {

    public static final float RADIUS = 70f;// 圆的半径 = 70
    private Test test;// 当前点坐标
    private Paint mPaint;// 绘图画笔

    public MyViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (test == null) {
            test = new Test(RADIUS, RADIUS);
            float x = test.x;
            float y = test.y;
            canvas.drawCircle(x, y, RADIUS, mPaint);
            Test testStart = new Test(RADIUS, RADIUS);
            Test testEnd = new Test(500, 500);
            ValueAnimator anim = ValueAnimator.ofObject(new MyTypeEvaluator(), testStart, testEnd);
            anim.setDuration(5000);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    test = (Test) animation.getAnimatedValue();
                    invalidate();
                }
            });
            anim.start();
        } else {

            float x = test.x;
            float y = test.y;
            canvas.drawCircle(x, y, RADIUS, mPaint);
        }
    }
}
