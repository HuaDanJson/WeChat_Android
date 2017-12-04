package com.android.frame.ui.fragmnet;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;
import com.android.frame.bean.WeChatDataBean;
import com.android.frame.utils.retrofitUtils.HttpResponseListener;
import com.android.frame.utils.retrofitUtils.Request;
import com.android.frame.utils.retrofitUtils.RetrofitUtil;
import com.apkfuns.logutils.LogUtils;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;


public class WeChatFragment extends BaseFragment {

    private String TAG = "WeChatFragment";

    @Override
    public void initView() {

        Request request = RetrofitUtil.newPostRequest("user/jsmith/tweets");
        RetrofitUtil.send(request, new HttpResponseListener<WeChatDataBean>() {

            @Override
            public void onResponse(WeChatDataBean weChatDataBean, Headers headers) {
                LogUtils.tag(TAG).d("Bean  " + weChatDataBean);
                LogUtils.tag(TAG).d("Headers   " + headers);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                super.onFailure(call, e);
                LogUtils.tag(TAG).d(call);
                LogUtils.tag(TAG).d(e);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment1;
    }

    public static WeChatFragment instanceFragment() {
        WeChatFragment weChatFragment = new WeChatFragment();
        return weChatFragment;
    }


}
