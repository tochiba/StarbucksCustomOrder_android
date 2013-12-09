package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;

import com.koganepj.starbuckscustomorder.R;

public class MenuTabListener extends AbstractTabListener {

    public MenuTabListener(ActionBar actionBar, FragmentManager fragmentManager, int rootViewId) {
        super(actionBar, fragmentManager, rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_menu;
    }

    @Override
    Fragment getFragment() {
        return new Fragment();
    }
    
}
