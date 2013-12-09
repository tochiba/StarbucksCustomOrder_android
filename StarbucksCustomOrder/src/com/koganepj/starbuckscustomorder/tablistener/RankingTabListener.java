package com.koganepj.starbuckscustomorder.tablistener;

import com.koganepj.starbuckscustomorder.R;

import android.app.ActionBar;

public class RankingTabListener extends AbstractTabListener {

    public RankingTabListener(ActionBar actionBar) {
        super(actionBar);
    }

    @Override
    int getTitleStrId() {
        return R.string.tab_ranking;
    }

}
