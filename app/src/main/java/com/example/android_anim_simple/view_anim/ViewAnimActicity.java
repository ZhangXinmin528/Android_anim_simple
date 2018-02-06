package com.example.android_anim_simple.view_anim;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.android_anim_simple.R;

/**
 * Created by ZhangXinmin on 2017/7/4.
 * Copyright (c) 2017 . All rights reserved.
 * View Animation:视图动画，又称补间动画。
 */

public class ViewAnimActicity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private ImageView mRobotIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initParamsAndValues();

        initViews();
    }

    private void initParamsAndValues() {
        mContext = this;
    }

    private void initViews() {
        mRobotIv = (ImageView) findViewById(R.id.iv_view_anim);
        findViewById(R.id.btn_view_alpha).setOnClickListener(this);
        findViewById(R.id.btn_view_scale).setOnClickListener(this);
        findViewById(R.id.btn_view_translate).setOnClickListener(this);
        findViewById(R.id.btn_view_rotate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_alpha:
                Animation alphaAnim = AnimationUtils.loadAnimation(mContext, R.anim.anim_alpha);
                mRobotIv.startAnimation(alphaAnim);
                break;
            case R.id.btn_view_scale:
                Animation scaleAnim = AnimationUtils.loadAnimation(mContext, R.anim.anim_scale);
                mRobotIv.startAnimation(scaleAnim);
                break;
            case R.id.btn_view_translate:
                Animation translateAnim = AnimationUtils.loadAnimation(mContext, R.anim.anim_translate);
                mRobotIv.startAnimation(translateAnim);
                break;
            case R.id.btn_view_rotate:
                Animation rotateeAnim = AnimationUtils.loadAnimation(mContext, R.anim.anim_rotate);
                mRobotIv.startAnimation(rotateeAnim);
                break;

        }
    }
}
