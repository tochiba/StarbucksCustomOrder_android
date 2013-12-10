package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.view.like.LikeFragment;

public class LikeTabListener extends AbstractTabListener {

    public LikeTabListener(ActionBar actionBar, FragmentManager fragmentManager, int rootViewId) {
        super(actionBar, fragmentManager, rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_like;
    }

    @Override
    Fragment getFragment() {
        return new LikeFragment();
    }
}
