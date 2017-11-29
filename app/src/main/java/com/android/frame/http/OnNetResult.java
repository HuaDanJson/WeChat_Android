package com.android.frame.http;


//网络操作回调
public interface OnNetResult<T> {
    void onNetSuccess(T data);
    void onNetFail(String errorMsg);
}
