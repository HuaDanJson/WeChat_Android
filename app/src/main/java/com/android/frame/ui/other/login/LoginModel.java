package com.android.frame.ui.other.login;

import com.android.frame.http.IApi;
import com.android.frame.http.OnNetResult;
import com.android.frame.http.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginModel implements LoginContract.LoginModel {
    @Override
    public void login(String user,
                      String pasd,
                      final OnNetResult<LoginBean> result) {
        //发起登录网络请求
        //Retrofit 处理

        IApi api = RetrofitHelper.getInstance().getApi();
        Call<LoginBean> login = api.login(user, pasd);

        login.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                //登录成功
                result.onNetSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                result.onNetFail(t.getMessage());
            }
        });

        Observable<LoginBean> observable = api.login1(user, pasd);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        result.onNetFail(e.getMessage());
                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        result.onNetSuccess(bean);
                    }
                });

    }


}
