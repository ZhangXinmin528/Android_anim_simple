package com.example.android_anim_simple.drawable_anim;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android_anim_simple.R;
import com.example.android_anim_simple.frameAnim.FrameAnimator;
import com.example.android_anim_simple.frameAnim.FrameAnimatorBuilder;

/**
 * Created by ZhangXinmin on 2017/7/4.
 * Copyright (c) 2017 . All rights reserved.
 * Drawable Animation:帧动画示例
 */

public class DrawableAnimActivity extends AppCompatActivity {
    private Button btn;
    private ImageView imageView;
    private AnimationDrawable animation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        btn = (Button) findViewById(R.id.btn_start);
        imageView = (ImageView) findViewById(R.id.iv_drawable);
        final FrameAnimator animator =
                new FrameAnimatorBuilder(this)
                        .setTarget(imageView)
                        .setDuration(100)
                        .setAnimRes(R.array.arrays_voiice)
                        .create();


        //传统帧动画
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setImageResource(R.drawable.anim_voice);
                animation = (AnimationDrawable) imageView.getDrawable();
                animation.start();
            }
        });*/

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert animator != null;
                animator.start();
            }
        });
    }
}
