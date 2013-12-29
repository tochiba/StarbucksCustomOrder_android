package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;

public abstract class AbstractTabListener implements TabListener {
    
    private int mRootViewId;
    
    private Fragment mFragment;
    
    public AbstractTabListener(int rootViewId) {
        mRootViewId = rootViewId;
    }
    
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {
        //Fragmentの切り替え
        transaction.add(mRootViewId, getFragment());
    }
    
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
        transaction.remove(getFragment());
    }
    
    @Override public void onTabReselected(Tab tab, FragmentTransaction ft) { }
    
    private Fragment getFragment() {
        if (mFragment == null) {
            mFragment = createFragment();
        }
        return mFragment;
    }
    
    abstract int getTitleStrId();
    abstract Fragment createFragment();
    
}
