package com.android.frame.ui.fragmnet;

import com.android.frame.R;
import com.android.frame.base.BaseFragment;


public class ContactListFragment extends BaseFragment{

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment2;
    }

    public static ContactListFragment instanceFragment(){

        ContactListFragment contactListFragment =new ContactListFragment();
        return contactListFragment;
    }

}
