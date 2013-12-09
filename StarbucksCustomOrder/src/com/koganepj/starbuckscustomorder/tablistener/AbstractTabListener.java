package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public abstract class AbstractTabListener implements TabListener {
    
    private ActionBar mActionBar;
    private FragmentManager mFragmentManager;
    private int mRootViewId;
    
    public AbstractTabListener(ActionBar actionBar, FragmentManager fragmentManager, int rootViewId) {
        mActionBar = actionBar;
        mFragmentManager = fragmentManager;
        mRootViewId = rootViewId;
    }
    
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        //タイトルの設定
        mActionBar.setTitle(getTitleStrId());
        
        //Fragmentの切り替え
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(mRootViewId, getFragment());
        transaction.commitAllowingStateLoss();
    }
    
    @Override public void onTabReselected(Tab tab, FragmentTransaction ft) { }
    @Override public void onTabUnselected(Tab tab, FragmentTransaction ft) { }
    
    abstract int getTitleStrId();
    abstract Fragment getFragment();
    
}
