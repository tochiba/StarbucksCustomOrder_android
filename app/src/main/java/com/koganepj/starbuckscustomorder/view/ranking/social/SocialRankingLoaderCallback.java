package com.koganepj.starbuckscustomorder.view.ranking.social;

import java.util.ArrayList;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

public class SocialRankingLoaderCallback implements LoaderCallbacks<ArrayList<SocialRankingModel>> {
    
    private Context mContext;
    private ArrayList<SocialRankingModel> mResult = new ArrayList<SocialRankingModel>();
    
    public SocialRankingLoaderCallback(Context context) {
        mContext = context;
    }

    @Override
    public Loader<ArrayList<SocialRankingModel>> onCreateLoader(int id, Bundle args) {
        return new SocialRankingModelLoader(mContext);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<SocialRankingModel>> loader, ArrayList<SocialRankingModel> data) {
        mResult = data;
    }

    @Override public void onLoaderReset(Loader<ArrayList<SocialRankingModel>> loader) { }
    
    public ArrayList<SocialRankingModel> getResult() {
        return mResult;
    }
    
}
