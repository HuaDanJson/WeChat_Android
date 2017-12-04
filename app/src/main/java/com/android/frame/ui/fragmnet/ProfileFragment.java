package com.android.frame.ui.fragmnet;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;
import com.android.frame.bean.UserInfoBean;
import com.android.frame.utils.retrofitUtils.HttpResponseListener;
import com.android.frame.utils.retrofitUtils.Request;
import com.android.frame.utils.retrofitUtils.RetrofitUtil;
import com.apkfuns.logutils.LogUtils;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;


public class ProfileFragment extends BaseFragment {

    private String TAG = "ProfileFragment";

    @Override
    public void initView() {
        Request request = RetrofitUtil.newPostRequest("/user/jsmith");
        Call call = RetrofitUtil.send(request, new HttpResponseListener<UserInfoBean>() {
            @Override
            public void onResponse(UserInfoBean userInfoBean, Headers headers) {
                LogUtils.tag(TAG).d("onResponse Bean  " + userInfoBean.toString());
                LogUtils.tag(TAG).d("Headers   " + headers);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                super.onFailure(call, e);
                LogUtils.tag(TAG).d("onFailure  call={}"+call+"  e={}"+e);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment4;
    }

    public static ProfileFragment instanceFragment() {
        ProfileFragment profileFragment = new ProfileFragment();
        return profileFragment;
    }


}
