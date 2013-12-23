package com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper;

import java.util.Comparator;

import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

public class CoffeeModelTypeComparator implements Comparator<SimpleCoffeeModel> {

    @Override
    public int compare(SimpleCoffeeModel lhs, SimpleCoffeeModel rhs) {
        return lhs.type.toString().compareTo(rhs.type.toString());
    }

}
