package com.android.frame.ui.other.login;

import com.android.frame.base.IBaseModle;
import com.android.frame.base.IBasePresenter;
import com.android.frame.base.IBaseView;
import com.android.frame.http.OnNetResult;

public class LoginContract {

    public interface LoginModel extends IBaseModle{
         void login(String user,
                    String pasd,
                    OnNetResult<LoginBean> result);
//        void register();
    }

    public interface LoginView extends IBaseView{
        //如果要展示数据，加上参数
        //不展示数据，不加参数
        void showLoginSuccess(LoginBean data);
        void showFaile();
//        void showResisterSuccess();
    }

    public interface LoginPresenter extends IBasePresenter {
        void login(String user, String pasd);
//        void register();
    }

}
