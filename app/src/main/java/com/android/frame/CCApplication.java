package com.android.frame;

import android.app.Activity;
import android.app.Application;

import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;


public class CCApplication extends Application {
    private static LiteOrm liteOrm;
    private static CCApplication app;

    private ArrayList<Activity> activitys=new ArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initLiteOrm();
    }

    private void initLiteOrm() {
        if (liteOrm == null) {
            liteOrm = LiteOrm.newSingleInstance(this, "liteorm.db");
        }
        liteOrm.setDebugged(true); // open the log
    }


    public void  addActivity(Activity activity){
        if(!activitys.contains(activity))
        activitys.add(activity);
    }

    public void removeActiivty(Activity activity){
        if(activitys.contains(activity)){
            activitys.remove(activity);
        }
    }

    public void exit(){
        for (Activity a:activitys) {
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
