package com.example.android_anim_simple.interpolator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_anim_simple.R;

/**
 * Created by ZhangXinmin on 2018/2/6.
 * Copyright (c) 2018 . All rights reserved.
 * 插值器效果展示
 */

public class InterpolatorDisplayActivity extends AppCompatActivity {
    public static final String PARAMS_TYPE = "type";

    private Context mContext;
    private TextView mDisplayTv;
    private ImageView mDisplayIv;

    private String mType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_display);

        initParamsAndValues();

        initViews();

    }

    private void initParamsAndValues() {
        mContext = this;

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null && bundle.containsKey(PARAMS_TYPE)) {
                mType = bundle.getString(PARAMS_TYPE);
            }
        }

    }

    private void initViews() {
        mDisplayTv = (TextView) findViewById(R.id.tv_inter_display);
        mDisplayIv = (ImageView) findViewById(R.id.iv_inter_anim);

        if (!TextUtils.isEmpty(mType)) {
            mDisplayTv.setText(getString(R.string.inter_type, mType));
        }

        findViewById(R.id.btn_inter_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAnim();
            }
        });
    }

    private void showAnim() {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.5f
        );

        animation.setDuration(2000);
        animation.setFillAfter(true);
        switch (mType) {
            case "AccelerateInterpolator":
                animation.setInterpolator(new AccelerateInterpolator());
                break;
            case "AccelerateDecelerateInterpolator":
                animation.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case "AnticipateInterpolator":
                animation.setInterpolator(new AnticipateInterpolator());
                break;
            case "AnticipateOvershootInterpolator":
                animation.setInterpolator(new AnticipateOvershootInterpolator());
                break;
            case "BounceInterpolator":
                animation.setInterpolator(new BounceInterpolator());
                break;
            case "CycleInterpolator":
                animation.setInterpolator(new CycleInterpolator(1.0f));
                break;
            case "DecelerateInterpolator":
                animation.setInterpolator(new DecelerateInterpolator());
                break;
            case "LinearInterpolator":
                animation.setInterpolator(new LinearInterpolator());
                break;
            case "PathInterpolator":
//                animation.setInterpolator(new PathInterpolator());
                break;
            case "OvershootInterpolator":
                animation.setInterpolator(new OvershootInterpolator());
                break;
            default:
                animation.setInterpolator(new LinearInterpolator());
                break;
        }
        mDisplayIv.startAnimation(animation);

    }
}
