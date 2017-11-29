package com.android.frame.ui.other.vertical;

import com.android.frame.CCApplication;
import com.android.frame.bean.DataBean;
import com.android.frame.bean.RoomBean;
import com.android.frame.http.HttpUtils;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;


public class VerticalModle implements VerticalContract.Modle {
    @Override
    public void getVertical(Map<String, String> params, Callback<DataBean> callback) {
        HttpUtils.getInstance().getVerticalData(params, callback);
    }

    //回调  Handler  EventBus   LcalBroadcaset
    public interface FromDbListener {
        public void onSucess(List<RoomBean> rooms);

        public void onFail(String msg);
    }

    @Override
    public void getVerticalFromDb(FromDbListener listener) {
        List<RoomBean> rooms = CCApplication.getLiteOrm().query(RoomBean.class);
        if (listener != null) {
            listener.onSucess(rooms);
        }
    }
}
