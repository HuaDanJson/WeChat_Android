package com.android.frame.ui.other.home;

import com.android.frame.base.IBaseModle;
import com.android.frame.base.IBasePresenter;
import com.android.frame.base.IBaseView;
import com.android.frame.bean.DataBean;
import com.android.frame.bean.RoomBean;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;


public class HomeContract {
    public interface View extends IBaseView{
        public void onGetVerticalSucess(List<RoomBean> rooms);
        public void onGetVerticalFail(String erro);
    }
    public interface Modle extends IBaseModle {
        public void getVertical(Map<String,String> params, Callback<DataBean> callback);
    }
    public interface  Presenter extends IBasePresenter {
        public void getVertical(Map<String,String> params);
    }
}
