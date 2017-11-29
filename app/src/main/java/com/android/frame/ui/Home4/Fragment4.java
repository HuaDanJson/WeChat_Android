package com.android.frame.ui.Home4;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;


public class Fragment4 extends BaseFragment {


    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment4;
    }
    public static Fragment4 instanceFragment(){

        Fragment4 fragment4=new Fragment4();
        return fragment4;
    }


}
