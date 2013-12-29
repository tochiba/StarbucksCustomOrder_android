package com.koganepj.starbuckscustomorder.view.ranking;

import java.util.Comparator;

import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

class CalorieComparator implements Comparator<SimpleCoffeeModel> {

    @Override
    public int compare(SimpleCoffeeModel lhs, SimpleCoffeeModel rhs) {
        return rhs.calorie.getCalorie() - lhs.calorie.getCalorie();
    }

}
