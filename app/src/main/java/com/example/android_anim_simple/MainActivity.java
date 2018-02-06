package com.example.android_anim_simple;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android_anim_simple.drawable_anim.DrawableAnimActivity;
import com.example.android_anim_simple.interpolator.InterpolatorActivity;
import com.example.android_anim_simple.view_anim.ViewAnimActicity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initParamsAndValues();

        initViews();
    }

    private void initParamsAndValues() {
        mContext = this;
    }

    private void initViews() {
        findViewById(R.id.btn_drawable).setOnClickListener(this);
        findViewById(R.id.btn_view).setOnClickListener(this);
        findViewById(R.id.btn_property).setOnClickListener(this);
        findViewById(R.id.btn_interpolator).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_view://视图动画
                Intent view = new Intent(mContext, ViewAnimActicity.class);
                startActivity(view);
                break;
            case R.id.btn_interpolator://插值器
                Intent interpolator = new Intent(mContext, InterpolatorActivity.class);
                startActivity(interpolator);
                break;
            case R.id.btn_drawable://帧动画
                Intent drawable = new Intent(mContext, DrawableAnimActivity.class);
                startActivity(drawable);
                break;
            case R.id.btn_property://属性动画

                break;
        }
    }
}
