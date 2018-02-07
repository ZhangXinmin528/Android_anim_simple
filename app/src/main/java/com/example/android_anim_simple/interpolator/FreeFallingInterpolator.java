package com.example.android_anim_simple.interpolator;

import android.animation.TimeInterpolator;
import android.util.Log;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;

/**
 * Created by ZhangXinmin on 2018/2/6.
 * Copyright (c) 2018 . All rights reserved.
 * 自由落体插值器
 */

public class FreeFallingInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float input) {
        Log.i("zxm", "input：" + input + "..value:" + ((float) Math.sqrt(0.5f * 9.8 * input * input)));
        return (float) Math.sqrt(0.5f * 9.8 * input * input);
    }
}
