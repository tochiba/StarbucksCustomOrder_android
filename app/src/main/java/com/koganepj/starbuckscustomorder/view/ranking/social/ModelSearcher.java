package com.koganepj.starbuckscustomorder.view.ranking.social;

import java.util.ArrayList;

import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

public class ModelSearcher {
    
    private ArrayList<SocialRankingModel> mRankingModels;
    private ArrayList<SimpleCoffeeModel> mCoffeeModels;
    
    public ModelSearcher(ArrayList<SocialRankingModel> rankingModels, ArrayList<SimpleCoffeeModel> coffeeModels) {
        mRankingModels = rankingModels;
        mCoffeeModels = coffeeModels;
    }
    
    public ArrayList<SimpleCoffeeModel> getList() {
        ArrayList<SimpleCoffeeModel> result = new ArrayList<SimpleCoffeeModel>();
        for (SocialRankingModel rankingModel : mRankingModels) {
            for (SimpleCoffeeModel coffeeModel : mCoffeeModels) {
                if (coffeeModel.coffeeName.getCoffeeName().equals(rankingModel.getCoffeeName().getCoffeeName())) {
                    result.add(coffeeModel);
                }
            }
        }
        return result;
    }
    
}
