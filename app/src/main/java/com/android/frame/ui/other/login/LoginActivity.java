package com.android.frame.ui.other.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.frame.R;

/**
 * 登录
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView{

    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter=new LoginPresenter(this);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login("a","b");
            }
        });
    }

    @Override
    public void showLoginSuccess(LoginBean data) {

    }

    @Override
    public void showFaile() {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }
}
