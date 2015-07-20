package com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper;

import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.model.Type;

public interface MenuCellModel {
    
    boolean isType();
    Type toType();
    SimpleCoffeeModel toSimpleCoffeeModel();
    
}
