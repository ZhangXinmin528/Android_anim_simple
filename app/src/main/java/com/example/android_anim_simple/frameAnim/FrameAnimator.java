package com.example.android_anim_simple.frameAnim;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.lang.ref.SoftReference;
import java.util.logging.Logger;

/**
 * Created by ZhangXinmin on 2018/8/17.
 * Copyright (c) 2018 . All rights reserved.
 */
public final class FrameAnimator {
    private static final String TAG = FrameAnimator.class.getSimpleName();

    private long mDuration;
    private int[] frames;//帧数组
    private ImageView mTarget;
    private int currentFrame;//当前帧
    private boolean isEnablePlay;//能否播放
    private boolean isPlaying;//是否在播放
    private SoftReference<ImageView> imageViewSoftReference;
    private Bitmap mBitmap;
    private Handler handler;
    private BitmapFactory.Options mBitmapOptions;
    private FrameAnimatorListener listener;

    public FrameAnimator(ImageView imageView, int[] frames, long duration) {
        this.frames = frames;
        this.mTarget = imageView;
        mDuration = duration;
        initParams();

    }

    @SuppressLint("ObsoleteSdkInt")
    private void initParams() {
        imageViewSoftReference = new SoftReference<>(mTarget);
        currentFrame = 1;
        isPlaying = false;
        isEnablePlay = false;
        handler = new Handler();

        mTarget.setImageResource(frames[0]);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            final Drawable drawable = mTarget.getDrawable();
            Log.e("frame", "image drawable ?null:" + (drawable == null));
            if (drawable != null) {
                final Bitmap bitmap = ((BitmapDrawable) (drawable)).getBitmap();
                final int width = bitmap.getWidth();
                final int height = bitmap.getHeight();
                Bitmap.Config config = bitmap.getConfig();
                mBitmap = Bitmap.createBitmap(width, height, config);
                mBitmapOptions = new BitmapFactory.Options();
                //设置Bitmap内存复用
                mBitmapOptions.inBitmap = mBitmap;//Bitmap复用内存块，类似对象池，避免不必要的内存分配和回收
                mBitmapOptions.inMutable = true;//解码时返回可变Bitmap
                mBitmapOptions.inSampleSize = 1;//缩放比例
            }

        }
    }

    /**
     * How long this animation should last. The duration cannot be negative.
     *
     * @param durationMillis Duration in milliseconds
     * @throws java.lang.IllegalArgumentException if the duration is < 0
     * @attr ref android.R.styleable#Animation_duration
     */
    public void _setDuration(long durationMillis) {
        if (durationMillis < 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative");
        }
        mDuration = durationMillis;
    }

    /**
     * 开始播放帧动画
     */
    public void start() {
        isEnablePlay = true;
        if (!isPlaying) {//是否播放动画
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    final ImageView target = imageViewSoftReference.get();
                    if (!isEnablePlay || target == null) {
                        isPlaying = false;
                        if (listener != null) {
                            listener.onAnimationEnd();
                        }
                    } else {
                        isPlaying = true;
                        //执行下一帧
                        handler.postDelayed(this, mDuration);

                        if (target.isShown()) {//控件没有隐藏
                            //获取下一帧照片
                            currentFrame++;
                            final int position = currentFrame % frames.length;
                            final int nextFrame = frames[position];
                            if (mBitmap != null) { // so Build.VERSION.SDK_INT >= 11
                                Bitmap bitmap = null;
                                try {
                                    bitmap = BitmapFactory.decodeResource(target.getResources(), nextFrame, mBitmapOptions);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (bitmap != null) {
                                    target.setImageBitmap(bitmap);
                                    Log.e("frame", "current frame:" + position);
                                } else {
                                    target.setImageResource(nextFrame);
                                    mBitmap.recycle();
                                    mBitmap = null;
                                }
                            } else {
                                target.setImageResource(nextFrame);
                            }
                        }
                    }
                }
            };

            handler.post(runnable);
        }
    }

    /**
     * 停止播放帧动画
     */
    public void stop() {
        isEnablePlay = false;
        if (listener != null) {
            listener.onAnimationEnd();
        }
    }

    public void _setListener(FrameAnimatorListener listener) {
        this.listener = listener;
    }
}
