package com.sx.ui.myView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ZhongView extends View {

    private int width, height;
    private Paint paintK, paintK1, paintM;
    private int widthR;
    private int heightR;
    private int widthK, widthK1;

    public ZhongView(Context context) {
        this(context, null);
    }

    public ZhongView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZhongView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //半径
        int width1 = getWidth();
        this.width = getWidth() << 2 << 2;

        int i = width1 + 1;

        paintK = new Paint();
        paintK.setAntiAlias(true);
        paintK.setStrokeWidth(15);
        paintK.setColor(Color.RED);
        paintK.setStyle(Paint.Style.STROKE);

        paintK1 = new Paint();
        paintK1.setAntiAlias(true);
        paintK1.setStrokeWidth(10);
        paintK1.setColor(Color.RED);
        paintK1.setStyle(Paint.Style.STROKE);

        paintM = new Paint();
        paintM.setAntiAlias(true);
        paintM.setStrokeWidth(2);
        paintM.setColor(Color.BLACK);
        paintM.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        widthR = width >> 2;
        widthK = widthR + 50;
        widthK1 = widthR + 30;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width >> 1, height >> 1, widthR, paintK);
        for (int i = 0; i < 12; i++) {
            canvas.rotate(30, width >> 1, height >> 1);
//            canvas.drawLine(widthK, height >> 1, width >> 1 + width >> 1, height >> 1, paintK);
        }
        for (int i = 0; i < 60; i++) {
            canvas.rotate(6, width >> 1, height >> 1);
//            canvas.drawLine(widthK1, height >> 1, width >> 1 + width >> 1, height >> 1, paintK1);
        }
    }



    private float mSecondDegree;
    private float mMinDegree;
    private float mHourDegree;


}
