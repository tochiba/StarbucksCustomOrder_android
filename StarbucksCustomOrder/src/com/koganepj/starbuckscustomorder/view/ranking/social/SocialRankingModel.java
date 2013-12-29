package com.koganepj.starbuckscustomorder.view.ranking.social;

import com.koganepj.starbuckscustomorder.model.CoffeeName;


public class SocialRankingModel {
    
    private int mRank;
    private CoffeeName mCoffeeName;
    
    public SocialRankingModel(int rank, CoffeeName coffeeName) {
        mRank = rank;
        mCoffeeName = coffeeName;
    }
    
    public int getRank() {
        return mRank;
    }
    
    public CoffeeName getCoffeeName() {
        return mCoffeeName;
    }
    
}
