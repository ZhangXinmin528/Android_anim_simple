package com.example.android_anim_simple.frameAnim;

import android.view.animation.Animation;

/**
 * Created by ZhangXinmin on 2018/8/17.
 * Copyright (c) 2018 . All rights reserved.
 * <p>
 * An frame animation listener receives notifications from an animation.
 * </p>
 */
public interface FrameAnimatorListener {
    /**
     * <p>Notifies the start of the animation.</p>
     *
     */
    void onAnimationStart();

    /**
     * <p>Notifies the end of the animation.
     *
     */
    void onAnimationEnd();

    /**
     * <p>Notifies the repetition of the animation.</p>
     *
     */
    void onAnimationRepeat();
}
