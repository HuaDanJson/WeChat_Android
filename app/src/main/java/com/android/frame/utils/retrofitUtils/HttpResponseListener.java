package com.android.frame.utils.retrofitUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;

public abstract class HttpResponseListener<T> {

    public Type getType() {
        Type mySuperClass = getClazz().getGenericSuperclass();
        Type type = ((ParameterizedType) mySuperClass).getActualTypeArguments()[0];
        return type;
    }

    public Class getClazz() {
        return getClass();
    }

    public abstract void onResponse(T t, Headers headers);

    public void onFailure(Call<ResponseBody> call, Throwable e) {
    }
}
