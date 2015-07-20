package com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper;

import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.model.Type;

class TypeAdapter implements MenuCellModel {
    
    private Type mType;
    
    public TypeAdapter(Type type) {
        mType = type;
    }
    
    @Override
    public boolean isType() {
        return true;
    }

    @Override
    public Type toType() {
        return mType;
    }

    @Override
    public SimpleCoffeeModel toSimpleCoffeeModel() {
        throw new UnsupportedOperationException("This is a type");
    }

}
