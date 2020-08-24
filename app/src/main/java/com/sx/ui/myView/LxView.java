package com.sx.ui.myView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class LxView extends View {


    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private float[] pts;
    private Paint paint4;
    private Rect rect;
    private RectF rectF;
    private RectF rectF1;
    private Path path1;
    private Paint paint5;
    private Path path2;
    private Path path3;
    private Paint paint6;

    public LxView(Context context) {
        this(context, null);
    }

    public LxView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LxView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //圆的画笔
        paint1 = new Paint();
        paint1.setAntiAlias(true);  //无锯齿
        paint1.setColor(Color.RED);
        paint1.setStyle(Paint.Style.STROKE); //不填充
        paint1.setStrokeWidth(5);

        //直线的画笔
        paint2 = new Paint();
        paint2.setColor(Color.BLUE);

        //多条直线
        paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(Color.CYAN);
        //画笔宽度
        paint3.setStrokeWidth(5);
        pts = new float[]{50, 100, 100, 200, 200, 300, 300, 400};
        //矩形
        paint4 = new Paint();
        paint4.setAntiAlias(true);
        paint4.setColor(Color.BLACK);
        rect = new Rect(300,300,600,400);
        //圆角矩形
        rectF = new RectF(600,600,700,700);
        //圆弧
        rectF1 = new RectF(700, 700, 1200, 1200);

        path1 = new Path();
        paint5 = new Paint();
        paint5.setStrokeWidth(5);
        paint5.setColor(Color.DKGRAY);
        paint5.setAntiAlias(true);
        paint5.setStyle(Paint.Style.STROKE);

        path2 = new Path();

        //贝塞尔曲线
        path3 = new Path();

        //绘制文字
        paint6 = new Paint();
        paint6.setAntiAlias(true);
        paint6.setTextAlign(Paint.Align.LEFT); //文本对齐方式
        paint6.setTextSize(40);
        paint6.setFakeBoldText(true);  //设置粗体
        paint6.setUnderlineText(true); //下划线
        paint6.setTextSkewX((float) -0.25); //倾斜
        paint6.setStrikeThruText(true); //删除线
        paint6.setTextScaleX(2); //水平拉伸


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

        //圆
        canvas.drawCircle(60, 200, 50, paint1);
        //直线
        canvas.drawLine(60, 60, 400, 60, paint2);
        //多条直线
        canvas.drawLines(pts, paint3);
        //绘制矩形
        canvas.drawRect(rect,paint4);
        canvas.drawRoundRect(rectF,20,20,paint4);
        //椭圆
        canvas.drawOval(100,400,300,500,paint1);
        //圆弧 0角度在1.4象限交界处 顺时针绘制角度
        canvas.drawArc(rectF1,0,135,false,paint1);

        path1.moveTo(100,100);
        path1.lineTo(100,600); //从0,0开始绘制
        path1.moveTo(400,400); //下次绘制开始的位置 不改变上次的绘制
        path1.lineTo(200,700);
        canvas.drawPath(path1,paint5);

        path2.moveTo(300,300);
        path2.lineTo(500,500);
        path2.setLastPoint(600,800); //改变上次绘制的结束位置
        path2.lineTo(900,900);
        path2.close();
        canvas.drawPath(path2,paint5);

        path3.moveTo(800,800);
        path3.quadTo(900,600,1200,800);
        canvas.drawPath(path3,paint5);

        canvas.drawText("文字文字文字",500,1000,paint6);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("////", "onTouchEvent: ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE:

                Log.d("////", "onTouchEvent: ACTION_MOVE");

                break;
            case MotionEvent.ACTION_UP:

                Log.d("////", "onTouchEvent: ACTION_UP");
                break;
        }

        return false;
    }
}
