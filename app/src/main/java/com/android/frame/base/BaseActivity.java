package com.android.frame.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.android.frame.CCApplication;

import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    CCApplication app;
    protected Handler mHandler;

    // 当前activity是否是前台运行状态
    public boolean isForegroundRunning = false;
    // 当前app是否是前台状态
    private static boolean isActive = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (CCApplication) getApplication();
        app.addActivity(this);
        ButterKnife.bind(this);
        isForegroundRunning = false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        app.removeActiivty(this);
    }

    public Handler getHandler() {
        if (mHandler == null) {
            synchronized (this) {
                if (mHandler == null) {
                    mHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mHandler;
    }


    public void doInUI(Runnable runnable) {
        doInUI(runnable, 0);
    }

    public void doInUI(Runnable runnable, long delayMillis) {
        getHandler().postDelayed(runnable, delayMillis);
    }

    public void toActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onResume() {
        super.onResume();
        isForegroundRunning = true;


        if (!isActive) {
            //app 从后台唤醒，进入前台
            isActive = true;

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isForegroundRunning = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isForegroundRunning = false;

        if (!isAppOnForeground()) {
            //app 进入后台
            isActive = false;
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        isForegroundRunning = false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public String getClassName() {
        return getClass().getSimpleName();
    }

    /**
     * 程序是否在前台运行
     *
     * @return
     */
    private boolean isAppOnForeground() {
        // Returns a list of application processes that are running on the device

        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();

        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName) && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }

    //是否连接WIFI
    public boolean isWifiConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    //设置屏幕背景透明度
    public void setBackgroundAlpha(float alpha) {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.alpha = alpha;
        getWindow().setAttributes(layoutParams);
    }

}