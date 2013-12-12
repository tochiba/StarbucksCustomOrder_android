package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.Fragment;

import com.koganepj.starbuckscustomorder.R;

public class MenuTabListener extends AbstractTabListener {

    private Fragment mFragmnet = null;
    
    public MenuTabListener(ActionBar actionBar, int rootViewId) {
        super(actionBar, rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_menu;
    }

    @Override
    Fragment getFragment() {
        if (mFragmnet == null) {
            mFragmnet = new Fragment();
        }
        return mFragmnet;
    }
    
}
