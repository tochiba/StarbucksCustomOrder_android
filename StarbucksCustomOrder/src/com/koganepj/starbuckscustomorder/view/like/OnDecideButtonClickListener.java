package com.koganepj.starbuckscustomorder.view.like;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.parse.CoffeeNameFinder;
import com.koganepj.starbuckscustomorder.view.like.matrix.MatrixSelectorLayout;

class OnDecideButtonClickListener implements OnClickListener {
    
    private MatrixSelectorLayout mMatrixSelectorLayout;
    private CoffeeNameFinder mCoffeeNameFinder;
    
    OnDecideButtonClickListener(MatrixSelectorLayout matrixSelectorLayout, CoffeeNameFinder finder) {
        mMatrixSelectorLayout = matrixSelectorLayout;
        mCoffeeNameFinder = finder;
    }
    
    @Override
    public void onClick(View v) {
        CoffeeName coffeeName = mCoffeeNameFinder.findName(mMatrixSelectorLayout.getSweetness(), mMatrixSelectorLayout.getHotness());
        
        Intent intent = new Intent(v.getContext(), CustomActivity.class);
        intent.putExtra(CustomActivity.KEY_PARAM_COFFEENAME, coffeeName);
        v.getContext().startActivity(intent);
    }

}
