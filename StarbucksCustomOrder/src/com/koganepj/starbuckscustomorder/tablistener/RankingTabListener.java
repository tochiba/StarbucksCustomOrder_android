package com.koganepj.starbuckscustomorder.tablistener;

import android.app.ActionBar;
import android.app.Fragment;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.view.ranking.RankingFragment;

public class RankingTabListener extends AbstractTabListener {

    public RankingTabListener(ActionBar actionBar, int rootViewId) {
        super(actionBar, rootViewId);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_ranking;
    }

    @Override
    Fragment createFragment() {
        return new RankingFragment();
    }

}
