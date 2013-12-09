package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;

import com.koganepj.starbuckscustomorder.R;

public class LikeTabListener extends AbstractTabListener {

    public LikeTabListener(ActionBar actionBar) {
        super(actionBar);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_like;
    }
}
