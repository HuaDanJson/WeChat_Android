package com.android.frame.utils.retrofitUtils;

public enum RequestMethod {

    GET("GET"),
    POST("POST");
    private final String value;

    RequestMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
