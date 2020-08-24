package com.sx.ui.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.sx.R;
import com.sx.presenter.MyTypeEvaluator;
import com.sx.presenter.Test;

public class Fab2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab2);
        ImageView iv = findViewById(R.id.iv);
        //帧动画
        iv.setImageResource(R.drawable.gif_list);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv.getDrawable();
        animationDrawable.start();

        //渐变动画
        ImageView iv2 = findViewById(R.id.iv2);
        Animation animation2 = AnimationUtils.loadAnimation(Fab2Activity.this, R.anim.anims);
        iv2.setAnimation(animation2);

        //旋转动画
        ImageView iv3 = findViewById(R.id.iv3);
        Animation animation3 = AnimationUtils.loadAnimation(Fab2Activity.this, R.anim.anims3);
        iv3.setAnimation(animation3);

        //缩放动画
        ImageView iv4 = findViewById(R.id.iv4);
        Animation animation4 = AnimationUtils.loadAnimation(Fab2Activity.this, R.anim.anims4);
//        animation4.setInterpolator(new CycleInterpolator(2));
        iv4.setAnimation(animation4);

        //位移动画
        ImageView iv5 = findViewById(R.id.iv5);
        Animation animation5 = AnimationUtils.loadAnimation(Fab2Activity.this, R.anim.anims5);
        iv5.setAnimation(animation5);

        final Button b = findViewById(R.id.bb);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(500,200);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                b.getLayoutParams().width = animatedValue;
                b.requestLayout();
            }
        });
        valueAnimator.start();

        final Button bbb = findViewById(R.id.bbb);
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(1.0f,200.0f,0.0f);
        valueAnimator1.setDuration(1000);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float animatedValue = (Float) animation.getAnimatedValue();
                bbb.setX(animatedValue);
            }
        });
        valueAnimator1.start();

        Button b4 = findViewById(R.id.b4);
        ObjectAnimator translate = ObjectAnimator.ofFloat(b4, "rotation", 0f,360f);
        translate.setInterpolator(new CycleInterpolator(1));
        translate.setDuration(5000);
        translate.start();

        final Button b5 = findViewById(R.id.b5);
        Test testStart = new Test(1.0f, 2.0f);
        Test testEnd = new Test(1.0f, 2.0f);
        MyTypeEvaluator myTypeEvaluator = new MyTypeEvaluator();
        ValueAnimator valueAnimator3 = ValueAnimator.ofObject(myTypeEvaluator, testStart, testEnd);
        valueAnimator3.setDuration(2000);
        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Test test = (Test)animation.getAnimatedValue();
                b5.getLayoutParams().width = (int) test.x+100;
                b5.getLayoutParams().height = (int) test.y+100;

                b5.requestLayout();
            }
        });
        valueAnimator3.start();
    }
}
