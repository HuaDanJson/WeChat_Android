package com.android.frame.ui.other.login;

import com.android.frame.http.OnNetResult;


public class LoginPresenter implements LoginContract.LoginPresenter {

    LoginModel  model;
    LoginContract.LoginView view;
    public LoginPresenter(LoginContract.LoginView view) {
        model=new LoginModel();
        this.view=view;
    }

    @Override
    public void login(String user, String pasd) {
        // user, pasd 加上判断
        model.login(user, pasd, new OnNetResult<LoginBean>() {
            @Override
            public void onNetSuccess(LoginBean data) {
                //成功
                view.showLoginSuccess(data);
            }

            @Override
            public void onNetFail(String errorMsg) {
                //失败
                view.showFaile();
            }
        });
    }
}
