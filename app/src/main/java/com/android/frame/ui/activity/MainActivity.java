package com.android.frame.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import com.android.frame.R;
import com.android.frame.base.BaseActivity;
import com.android.frame.ui.fragmnet.Fragment1;
import com.android.frame.ui.fragmnet.Fragment2;
import com.android.frame.ui.fragmnet.Fragment3;
import com.android.frame.ui.fragmnet.Fragment4;
import com.android.frame.ui.other.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
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

            fragment1 = (Fragment1) getSupportFragmentManager().findFragmentByTag("fragment");
            fragment2 = (Fragment2) getSupportFragmentManager().findFragmentByTag("fragment2");
            fragment3 = (Fragment3) getSupportFragmentManager().findFragmentByTag("fragment3");
            fragment4 = (Fragment4) getSupportFragmentManager().findFragmentByTag("fragment4");
            currentTabPosition = savedInstanceState.getInt(HOME_CURRENT_TAB_POSITION);
        } else {
            fragment1 = Fragment1.instanceFragment();
            fragment2 = Fragment2.instanceFragment();
            fragment3 = Fragment3.instanceFragment();
            fragment4 = Fragment4.instanceFragment();

            //transaction里添加fragment
            transaction.add(R.id.linearlayout_main, fragment1, "fragment1");
            transaction.add(R.id.linearlayout_main, fragment2, "fragment2");
            transaction.add(R.id.linearlayout_main, fragment3, "fragment3");
            transaction.add(R.id.linearlayout_main, fragment4, "fragment4");

        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        bottomTabLayout.setCurrentTab(currentTabPosition);
    }

    private void SwitchTo(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                transaction.show(fragment1);
                transaction.hide(fragment2);
                transaction.hide(fragment3);
                transaction.hide(fragment4);
                transaction.commitAllowingStateLoss();
                break;
            case 1:
                transaction.show(fragment2);
                transaction.hide(fragment1);
                transaction.hide(fragment3);
                transaction.hide(fragment4);
                transaction.commitAllowingStateLoss();
                break;
            case 2:
                transaction.show(fragment3);
                transaction.hide(fragment2);
                transaction.hide(fragment1);
                transaction.hide(fragment4);
                transaction.commitAllowingStateLoss();
                break;
            case 3:
                transaction.show(fragment4);
                transaction.hide(fragment2);
                transaction.hide(fragment3);
                transaction.hide(fragment1);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;

        }

    }


}