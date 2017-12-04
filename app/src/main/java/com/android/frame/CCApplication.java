package com.android.frame;

import android.app.Activity;
import android.app.Application;

import com.android.frame.utils.SharePreferenceUtil;
import com.android.frame.utils.ToastHelper;
import com.android.frame.utils.retrofitUtils.RetrofitUtil;
import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;


public class CCApplication extends Application {

    private static LiteOrm liteOrm;
    private static CCApplication app;

    private ArrayList<Activity> activitys = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initLiteOrm();
        SharePreferenceUtil.initInstance(getApplicationContext(), SharePreferenceUtil.MODE_ENCRYPT_ALL);
        ToastHelper.init(this);

        RetrofitUtil.init(getApplicationContext(),"http://thoughtworks-ios.herokuapp.com/");
    }

    private void initLiteOrm() {
        if (liteOrm == null) {
            liteOrm = LiteOrm.newSingleInstance(this, "liteorm.db");
        }
        liteOrm.setDebugged(true); // open the log
    }


    public void addActivity(Activity activity) {
        if (!activitys.contains(activity)) {
            activitys.add(activity);
        }
    }

    public void removeActiivty(Activity activity) {
        if (activitys.contains(activity)) {
            activitys.remove(activity);
        }
    }

    public void exit() {
        for (Activity a : activitys) {
            a.finish();
        }
    }

    public static CCApplication getInstance() {
        return app;
    }

    public static LiteOrm getLiteOrm() {
        return liteOrm;
    }
}
