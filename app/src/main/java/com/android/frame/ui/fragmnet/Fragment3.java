package com.android.frame.ui.fragmnet;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;


public class Fragment3 extends BaseFragment {
    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment3;
    }

    public static Fragment3 instanceFragment(){

        Fragment3 fragment3=new Fragment3();
        return fragment3;
    }
}
