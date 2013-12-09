package com.koganepj.starbuckscustomorder.tablistener;

import com.koganepj.starbuckscustomorder.R;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;

public class RankingTabListener extends AbstractTabListener {

    public RankingTabListener(ActionBar actionBar, FragmentManager fragmentManager, int rootViewId) {
        super(actionBar, fragmentManager, rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_ranking;
    }

    @Override
    Fragment getFragment() {
        return new Fragment();
    }

}
