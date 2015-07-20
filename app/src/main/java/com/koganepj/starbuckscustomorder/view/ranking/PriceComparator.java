package com.koganepj.starbuckscustomorder.view.ranking;

import java.util.Comparator;

import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

class PriceComparator implements Comparator<SimpleCoffeeModel> {

    @Override
    public int compare(SimpleCoffeeModel lhs, SimpleCoffeeModel rhs) {
        return rhs.price.getPrice() - lhs.price.getPrice();
    }

}
