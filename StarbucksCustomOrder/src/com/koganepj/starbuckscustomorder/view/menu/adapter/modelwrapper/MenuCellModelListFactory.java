package com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.model.Type;

public class MenuCellModelListFactory {
    
    public ArrayList<MenuCellModel> create(List<SimpleCoffeeModel> coffeeModelList) {
        //ソートする
        Collections.sort(coffeeModelList, new CoffeeModelTypeComparator());
        
        //順にデータを入れていく（途中で必要なら帯の表示用のデータを差し込む）
        ArrayList<MenuCellModel> resultList = new ArrayList<MenuCellModel>();
        Type currentType = new Type("");
        for (SimpleCoffeeModel coffeeModel : coffeeModelList) {
            //タイプが変わっていれば入れる
            if (currentType.getType().equals(coffeeModel.type.getType()) == false) {
                resultList.add(new TypeAdapter(coffeeModel.type));
                currentType = coffeeModel.type; //現在のタイプとして保持しておく
            }
            
            //モデルそのものを入れる
            resultList.add(new CoffeeModelAdapter(coffeeModel));
        }
        
        return resultList;
    }
    
}
