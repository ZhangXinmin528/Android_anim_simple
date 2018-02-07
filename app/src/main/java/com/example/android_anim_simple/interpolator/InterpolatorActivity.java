package com.example.android_anim_simple.interpolator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android_anim_simple.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.android_anim_simple.interpolator.InterpolatorDisplayActivity.PARAMS_TYPE;

/**
 * Created by ZhangXinmin on 2018/2/6.
 * Copyright (c) 2018 . All rights reserved.
 * 插值器
 */

public class InterpolatorActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Context mContext;

    private ListView mListView;
    private List<String> mDataList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        initParamsAndValues();

        initViews();

        initData();
    }

    private void initParamsAndValues() {
        mContext = this;
        mDataList = new ArrayList<>();

        mAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, mDataList);
    }

    private void initViews() {
        mListView = (ListView) findViewById(R.id.listview_interp);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

    }

    private void initData() {
        mDataList.add("AccelerateInterpolator");
        mDataList.add("AccelerateDecelerateInterpolator");
        mDataList.add("AnticipateInterpolator");
        mDataList.add("AnticipateOvershootInterpolator");
        mDataList.add("BounceInterpolator");
        mDataList.add("CycleInterpolator");
        mDataList.add("DecelerateInterpolator");
        mDataList.add("LinearInterpolator");
        mDataList.add("PathInterpolator");
        mDataList.add("OvershootInterpolator");
        mDataList.add("FreeFallingInterpolator");

        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final String tag = (String) parent.getAdapter().getItem(position);
        Intent intent = new Intent(mContext, InterpolatorDisplayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PARAMS_TYPE, tag);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
