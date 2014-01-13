package com.koganepj.starbuckscustomorder.custom;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.custom.view.TempuretureSelectView;
import com.koganepj.starbuckscustomorder.model.CustomizeCoffee;
import com.koganepj.starbuckscustomorder.order.OrderActivity;

class MagicClickListener implements OnClickListener {
    
    private CustomizeDataHolder mCustomizeDataHolder;
    private TempuretureSelectView mTempuretureSelectView;
    
    public MagicClickListener(CustomizeDataHolder customizeDataHolder, TempuretureSelectView tempuretureSelectView) {
        mCustomizeDataHolder = customizeDataHolder;
        mTempuretureSelectView = tempuretureSelectView;
    }
    
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), OrderActivity.class);

        CustomizeCoffee customizeCoffe = mCustomizeDataHolder.getCustomizeCoffe(v.getContext(), mTempuretureSelectView.getSelectedTempureture());
        intent.putExtra(OrderActivity.KEY_JUMON, customizeCoffe.getJumon());
        
        intent.putExtra(OrderActivity.KEY_PHOTO, mCustomizeDataHolder.getCoffeePhoto());
        v.getContext().startActivity(intent);
    }
    
}
