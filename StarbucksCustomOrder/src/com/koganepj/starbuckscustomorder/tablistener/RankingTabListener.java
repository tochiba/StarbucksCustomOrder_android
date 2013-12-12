package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.Fragment;

import com.koganepj.starbuckscustomorder.R;

public class RankingTabListener extends AbstractTabListener {
    
    private Fragment mFragment;

    public RankingTabListener(ActionBar actionBar, int rootViewId) {
        super(actionBar, rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_ranking;
    }

    @Override
    Fragment getFragment() {
        if (mFragment == null) {
            mFragment = new Fragment();
        }
        return mFragment;
    }

}
