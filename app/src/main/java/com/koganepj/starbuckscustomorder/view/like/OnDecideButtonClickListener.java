package com.koganepj.starbuckscustomorder.view.like;

import java.util.HashMap;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Hotness;
import com.koganepj.starbuckscustomorder.model.Sweetness;
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
        Sweetness sweetness = mMatrixSelectorLayout.getSweetness();
        Hotness hotness = mMatrixSelectorLayout.getHotness();
        CoffeeName coffeeName = mCoffeeNameFinder.findName(sweetness, hotness);
        
        Intent intent = new Intent(v.getContext(), CustomActivity.class);
        intent.putExtra(CustomActivity.KEY_PARAM_COFFEENAME, coffeeName);
        v.getContext().startActivity(intent);
        
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("hotness", String.valueOf(hotness.getLevel()));
        params.put("sweetness", String.valueOf(sweetness.getLevel()));
        FlurryWrapper.logEvent("okonomi_decide", params);
    }

}
