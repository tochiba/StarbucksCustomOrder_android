package com.koganepj.starbuckscustomorder.tablistener;

import android.app.Fragment;

import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.view.ranking.RankingFragment;

public class RankingTabListener extends AbstractTabListener {

    public RankingTabListener(int rootViewId) {
        super(rootViewId);
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
