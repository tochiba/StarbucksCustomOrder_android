package com.koganepj.starbuckscustomorder.view.ranking;

import java.util.ArrayList;
import java.util.Collections;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.view.ranking.adapter.RankingAdapter;
import com.koganepj.starbuckscustomorder.view.ranking.social.ModelSearcher;
import com.koganepj.starbuckscustomorder.view.ranking.social.SocialRankingLoaderCallback;
import com.koganepj.starbuckscustomorder.view.ranking.social.SocialRankingModel;

class TypeSelectListener implements OnCheckedChangeListener {
    
    private RankingAdapter mAdapter;
    private ArrayList<SimpleCoffeeModel> mCoffeeModels;
    private SocialRankingLoaderCallback mCallback;
    
    public TypeSelectListener(RankingAdapter adapter, ArrayList<SimpleCoffeeModel> coffeeModels, SocialRankingLoaderCallback callback) {
        mAdapter = adapter;
        mCoffeeModels = coffeeModels;
        mCallback = callback;
    }
    
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.RadioCalorie) {
            mAdapter.clear();
            
            ArrayList<SimpleCoffeeModel> copiedList = new ArrayList<SimpleCoffeeModel>(mCoffeeModels);
            Collections.sort(copiedList, new CalorieComparator());
            
            mAdapter.addAll(copiedList);
            return;
        }
        
        if (checkedId == R.id.RadioPrice) {
            mAdapter.clear();
            
            ArrayList<SimpleCoffeeModel> copiedList = new ArrayList<SimpleCoffeeModel>(mCoffeeModels);
            Collections.sort(copiedList, new PriceComparator());
            
            mAdapter.addAll(copiedList);
            return;
        }

        if (checkedId == R.id.RadioSocial) {
            mAdapter.clear();
            ModelSearcher searcher = new ModelSearcher(mCallback.getResult(), mCoffeeModels);
            ArrayList<SimpleCoffeeModel> list = searcher.getList();
            mAdapter.addAll(list);
            return;
        }
    }
    
}
