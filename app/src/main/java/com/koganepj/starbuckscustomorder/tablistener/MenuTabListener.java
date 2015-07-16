package com.koganepj.starbuckscustomorder.tablistener;

import android.app.Fragment;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.view.menu.MenuFragment;

public class MenuTabListener extends AbstractTabListener {

    public MenuTabListener(int rootViewId) {
        super(rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_menu;
    }

    @Override
    Fragment createFragment() {
        return new MenuFragment();
    }
    
}
