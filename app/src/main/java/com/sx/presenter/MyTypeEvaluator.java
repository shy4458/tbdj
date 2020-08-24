package com.sx.presenter;

import android.animation.TypeEvaluator;

public class MyTypeEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {

        Test testStart = (Test) startValue;
        Test testEnd = (Test) endValue;

        float x = testStart.x + fraction * (testEnd.x - testStart.x);
        float y = testStart.y + fraction * (testEnd.y - testStart.y);

        Test test = new Test(x, y);

        return test;
    }

}
