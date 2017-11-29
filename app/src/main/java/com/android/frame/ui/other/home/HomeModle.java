package com.android.frame.ui.other.home;

import com.android.frame.bean.DataBean;
import com.android.frame.http.HttpUtils;

import java.util.Map;

import retrofit2.Callback;


public class HomeModle implements HomeContract.Modle {
    @Override
    public void getVertical(Map<String, String> params, Callback<DataBean> callback) {
        HttpUtils.getInstance().getVerticalData(params, callback);
    }
}
