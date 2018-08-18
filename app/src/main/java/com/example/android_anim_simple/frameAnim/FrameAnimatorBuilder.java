package com.example.android_anim_simple.frameAnim;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by ZhangXinmin on 2018/8/17.
 * Copyright (c) 2018 . All rights reserved.
 * The builder class for Frame Animation to avoid OutOfMemory.
 */
public final class FrameAnimatorBuilder {
    //recommend to use application context;
    private Context mContext;

    private ImageView mTarget;

    private long mDuration;

    private int imgRes;

    private FrameAnimatorListener mListener;

    public FrameAnimatorBuilder(Context context) {
        mContext = context;
    }

    public FrameAnimatorBuilder setTarget(ImageView target) {
        mTarget = target;
        return this;
    }

    public FrameAnimatorBuilder setAnimRes(@ArrayRes int imgRes) {
        this.imgRes = imgRes;
        return this;
    }

    public FrameAnimatorBuilder setDuration(long duration) {
        mDuration = duration;
        return this;
    }

    public FrameAnimatorBuilder setAnimationListener(FrameAnimatorListener listener) {
        mListener = listener;
        return this;
    }

    public FrameAnimator create() {
        TypedArray array = mContext.getResources().obtainTypedArray(imgRes);

        int len = array.length();
        int[] intArray = new int[array.length()];

        for(int i = 0; i < len; i++){
            intArray[i] = array.getResourceId(i, 0);
        }
        array.recycle();
        if (len != 0) {
            final FrameAnimator animator = new FrameAnimator(mTarget, intArray, mDuration);
            if (mListener != null) {
                animator._setListener(mListener);
            }
            return animator;
        } else {
            Log.e("frame","Frame animation resources is null!");
            return null;
        }
    }



}
