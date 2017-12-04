package com.android.frame.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import com.android.frame.R;
import com.android.frame.base.BaseActivity;
import com.android.frame.ui.fragmnet.FindFragment;
import com.android.frame.ui.fragmnet.ProfileFragment;
import com.android.frame.ui.fragmnet.WeChatFragment;
import com.android.frame.ui.fragmnet.ContactListFragment;
import com.android.frame.ui.other.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private WeChatFragment weChatFragment;
    private ContactListFragment contactListFragment;
    private FindFragment findFragment;
    private ProfileFragment profileFragment;
    public static final String HOME_CURRENT_TAB_POSITION = "HOME_CURRENT_TAB_POSITION";

    private CommonTabLayout bottomTabLayout;
    private String[] mTitles = {"微信", "通讯录", "发现", "我"};
    private int[] mIconUnselectIds = {R.drawable.fx_conversation_normal, R.drawable.fx_contact_list_normal, R.drawable.fx_find_normal, R.drawable.fx_profile_normal};
    private int[] mIconSelectIds = {R.drawable.fx_conversation_selected, R.drawable.fx_contact_list_selected, R.drawable.fx_find_pressed, R.drawable.fx_profile_pressed};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomTabLayout = (CommonTabLayout) findViewById(R.id.main_tab_layout);
        initTab();
        initFragment(savedInstanceState);
    }

    //用来初始化底部导航
    private void initTab() {
        for (int i = 0; i < mIconSelectIds.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        bottomTabLayout.setTabData(mTabEntities);
        bottomTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

                SwitchTo(position);

            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }


    /**
     * 初始化碎片
     * private BianMinFragment bianMinFragment;
     * private CYFragment cyFragment;
     * private ChatFragment ChatFragment;
     * private jtFragment jtFragment;
     */
    public void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {//判断保留的数据是否为空

            weChatFragment = (WeChatFragment) getSupportFragmentManager().findFragmentByTag("fragment");
            contactListFragment = (ContactListFragment) getSupportFragmentManager().findFragmentByTag("contactListFragment");
            findFragment = (FindFragment) getSupportFragmentManager().findFragmentByTag("findFragment");
            profileFragment = (ProfileFragment) getSupportFragmentManager().findFragmentByTag("profileFragment");
            currentTabPosition = savedInstanceState.getInt(HOME_CURRENT_TAB_POSITION);
        } else {
            weChatFragment = WeChatFragment.instanceFragment();
            contactListFragment = ContactListFragment.instanceFragment();
            findFragment = FindFragment.instanceFragment();
            profileFragment = ProfileFragment.instanceFragment();

            //transaction里添加fragment
            transaction.add(R.id.linearlayout_main, weChatFragment, "weChatFragment");
            transaction.add(R.id.linearlayout_main, contactListFragment, "contactListFragment");
            transaction.add(R.id.linearlayout_main, findFragment, "findFragment");
            transaction.add(R.id.linearlayout_main, profileFragment, "profileFragment");

        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        bottomTabLayout.setCurrentTab(currentTabPosition);
    }

    private void SwitchTo(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                transaction.show(weChatFragment);
                transaction.hide(contactListFragment);
                transaction.hide(findFragment);
                transaction.hide(profileFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 1:
                transaction.show(contactListFragment);
                transaction.hide(weChatFragment);
                transaction.hide(findFragment);
                transaction.hide(profileFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 2:
                transaction.show(findFragment);
                transaction.hide(contactListFragment);
                transaction.hide(weChatFragment);
                transaction.hide(profileFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 3:
                transaction.show(profileFragment);
                transaction.hide(contactListFragment);
                transaction.hide(findFragment);
                transaction.hide(weChatFragment);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;

        }

    }


}