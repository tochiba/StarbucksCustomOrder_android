package com.koganepj.starbuckscustomorder.tablistener;

import android.app.Fragment;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.view.like.LikeFragment;

public class LikeTabListener extends AbstractTabListener {
    
    public LikeTabListener(int rootViewId) {
        super(rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_like;
    }

    @Override
    Fragment createFragment() {
        return new LikeFragment();
    }
}
