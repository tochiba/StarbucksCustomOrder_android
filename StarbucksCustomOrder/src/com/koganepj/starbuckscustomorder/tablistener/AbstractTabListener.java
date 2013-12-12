package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;

public abstract class AbstractTabListener implements TabListener {
    
    private ActionBar mActionBar;
    private int mRootViewId;
    
    public AbstractTabListener(ActionBar actionBar, int rootViewId) {
        mActionBar = actionBar;
        mRootViewId = rootViewId;
    }
    
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {
        //タイトルの設定
        mActionBar.setTitle(getTitleStrId());
        
        //Fragmentの切り替え
        transaction.add(mRootViewId, getFragment());
    }
    
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
        transaction.remove(getFragment());
    }
    
    @Override public void onTabReselected(Tab tab, FragmentTransaction ft) { }
    
    abstract int getTitleStrId();
    abstract Fragment getFragment();
    
}
