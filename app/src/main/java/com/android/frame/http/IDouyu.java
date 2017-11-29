package com.android.frame.http;

import com.android.frame.bean.DataBean;
import com.android.frame.config.UrlConfig;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;



public interface IDouyu {
//    http://capi.douyucdn.cn/api/v1/getVerticalRoom
    @GET(UrlConfig.Path.URL_VERTICAL)
    Call<DataBean> getVerticalData(@QueryMap()Map<String,String> params);
}
