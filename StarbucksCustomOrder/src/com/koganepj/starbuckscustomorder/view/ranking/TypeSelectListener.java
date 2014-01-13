package com.koganepj.starbuckscustomorder.view.ranking;

import java.util.ArrayList;
import java.util.Collections;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.admob.AdmobWrapper;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.view.ranking.adapter.RankingAdapter;
import com.koganepj.starbuckscustomorder.view.ranking.social.ModelSearcher;
import com.koganepj.starbuckscustomorder.view.ranking.social.SocialRankingLoaderCallback;

class TypeSelectListener implements OnCheckedChangeListener {
    
    private RankingAdapter mAdapter;
    private ArrayList<SimpleCoffeeModel> mCoffeeModels;
    private SocialRankingLoaderCallback mCallback;
    private AdmobWrapper mHeaderAd;
	private AdmobWrapper mFooterAd;
    
    
    public TypeSelectListener(RankingAdapter adapter, ArrayList<SimpleCoffeeModel> coffeeModels, SocialRankingLoaderCallback callback, AdmobWrapper headerAd, AdmobWrapper footerAd) {
        mAdapter = adapter;
        mCoffeeModels = coffeeModels;
        mCallback = callback;
        mHeaderAd = headerAd;
        mFooterAd = footerAd;
    }
    
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    	// 広告を更新
    	mHeaderAd.loadAd();
    	mFooterAd.loadAd();
    	
        if (checkedId == R.id.RadioCalorie) {
            FlurryWrapper.logEvent("ranking_change_mode_to_calorie");
            
            mAdapter.clear();
            
            ArrayList<SimpleCoffeeModel> copiedList = new ArrayList<SimpleCoffeeModel>(mCoffeeModels);
            Collections.sort(copiedList, new CalorieComparator());
            
            mAdapter.addAll(copiedList);
            return;
        }
        
        if (checkedId == R.id.RadioPrice) {
            FlurryWrapper.logEvent("ranking_change_mode_to_price");
            
            mAdapter.clear();
            
            ArrayList<SimpleCoffeeModel> copiedList = new ArrayList<SimpleCoffeeModel>(mCoffeeModels);
            Collections.sort(copiedList, new PriceComparator());
            
            mAdapter.addAll(copiedList);
            return;
        }

        if (checkedId == R.id.RadioSocial) {
            FlurryWrapper.logEvent("ranking_change_mode_to_social");
            
            mAdapter.clear();
            ModelSearcher searcher = new ModelSearcher(mCallback.getResult(), mCoffeeModels);
            ArrayList<SimpleCoffeeModel> list = searcher.getList();
            mAdapter.addAll(list);
            return;
        }
    }
    
}
