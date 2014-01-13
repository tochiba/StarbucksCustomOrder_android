package com.koganepj.starbuckscustomorder.view.menu;

import java.util.HashMap;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper.CoffeeModelAdapter;

class OnRowClickListener implements OnItemClickListener {
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CoffeeModelAdapter model = (CoffeeModelAdapter)parent.getItemAtPosition(position);
        if (model.isType()) {
            return;
        }
        
        Intent intent = new Intent(view.getContext(), CustomActivity.class);
        intent.putExtra(CustomActivity.KEY_PARAM_COFFEENAME, model.toSimpleCoffeeModel().coffeeName);
        view.getContext().startActivity(intent);
        
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("coffee", model.toSimpleCoffeeModel().coffeeName.getCoffeeName());
        FlurryWrapper.logEvent("menu_tap", params);
    }
    
}
