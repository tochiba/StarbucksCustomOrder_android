package com.koganepj.starbuckscustomorder.view.ranking;

import java.util.HashMap;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class OnRowClickListener implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SimpleCoffeeModel coffeeModel = (SimpleCoffeeModel)parent.getItemAtPosition(position);
        
        Intent intent = new Intent(view.getContext(), CustomActivity.class);
        intent.putExtra(CustomActivity.KEY_PARAM_COFFEENAME, coffeeModel.coffeeName);
        view.getContext().startActivity(intent);
        
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("coffee", coffeeModel.coffeeName.getCoffeeName());
        FlurryWrapper.logEvent("ranking_select", params);
    }

}
