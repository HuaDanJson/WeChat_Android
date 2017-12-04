package com.android.frame.ui.fragmnet;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;


public class Fragment1 extends BaseFragment {
    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment1;
    }

    public static Fragment1 instanceFragment(){

        Fragment1 fragment1=new Fragment1();
        return fragment1;
    }

}
