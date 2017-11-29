package com.android.frame.ui.Home2;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;


public class Fragment2 extends BaseFragment{
    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment2;
    }

    public static Fragment2 instanceFragment(){

        Fragment2 fragment2=new Fragment2();
        return fragment2;
    }

}
