package com.android.frame.ui.fragmnet;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;


public class Fragment5 extends BaseFragment {


    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment5;
    }

    public static Fragment5 instanceFragment(){

        Fragment5 fragment5=new Fragment5();
        return fragment5;
    }

}
