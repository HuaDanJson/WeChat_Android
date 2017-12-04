package com.android.frame.ui.fragmnet;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;


public class FindFragment extends BaseFragment {
    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment3;
    }

    public static FindFragment instanceFragment(){

        FindFragment findFragment =new FindFragment();
        return findFragment;
    }
}
