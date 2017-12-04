package com.android.frame.ui.activity;

import android.os.Bundle;

import com.android.frame.R;
import com.android.frame.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        doInUI(new Runnable() {
            @Override
            public void run() {
                toActivity(MainActivity.class);
                WelcomeActivity.this.finish();
            }
        }, 500);
    }
}
