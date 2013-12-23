package com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper;

import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.model.Type;

class CoffeeModelAdapter implements MenuCellModel {
    
    private SimpleCoffeeModel mCoffeeModel;
    
    public CoffeeModelAdapter(SimpleCoffeeModel coffeeModel) {
        mCoffeeModel = coffeeModel;
    }
    
    @Override
    public boolean isType() {
        return false;
    }

    @Override
    public Type toType() {
        throw new UnsupportedOperationException("This is a coffemodel");
    }

    @Override
    public SimpleCoffeeModel toSimpleCoffeeModel() {
        return mCoffeeModel;
    }

}
