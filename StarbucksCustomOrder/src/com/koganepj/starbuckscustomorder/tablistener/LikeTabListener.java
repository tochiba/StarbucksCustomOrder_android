package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.Fragment;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.view.like.LikeFragment;

public class LikeTabListener extends AbstractTabListener {
    
    private LikeFragment mLikeFragment = null;
    
    public LikeTabListener(ActionBar actionBar, int rootViewId) {
        super(actionBar, rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_like;
    }

    @Override
    Fragment getFragment() {
        if (mLikeFragment == null) {
            mLikeFragment = new LikeFragment();
        }
        return mLikeFragment;
    }
}
