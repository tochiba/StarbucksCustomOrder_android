package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;

public abstract class AbstractTabListener implements TabListener {
    
    private ActionBar mActionBar;
    
    public AbstractTabListener(ActionBar actionBar) {
        mActionBar = actionBar;
    }
    
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        mActionBar.setTitle(getTitleStrId());
    }
    
    @Override public void onTabReselected(Tab tab, FragmentTransaction ft) { }
    @Override public void onTabUnselected(Tab tab, FragmentTransaction ft) { }
    
    abstract int getTitleStrId();
    
}
