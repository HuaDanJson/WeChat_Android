package com.android.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.frame.CCApplication;

import butterknife.ButterKnife;

public abstract  class BaseActivity extends AppCompatActivity {

    CCApplication app;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
         app = (CCApplication) getApplication();
        app.addActivity(this);
        ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //做数据统计
    }

    @Override
    protected void onPause() {
        super.onPause();
        //做数据统计
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        app.removeActiivty(this);
    }

    protected abstract void initView(Bundle savedInstanceState);

    public abstract int getLayoutId();
}
