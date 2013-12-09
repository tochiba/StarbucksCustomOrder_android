package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;

import com.koganepj.starbuckscustomorder.R;

public class MenuTabListener extends AbstractTabListener {

    public MenuTabListener(ActionBar actionBar) {
        super(actionBar);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_menu;
    }
    
}
