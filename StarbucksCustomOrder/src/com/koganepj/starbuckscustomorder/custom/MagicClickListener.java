package com.koganepj.starbuckscustomorder.custom;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.order.OrderActivity;

class MagicClickListener implements OnClickListener {
    
    private CustomizeDataHolder mCustomizeDataHolder;
    
    public MagicClickListener(CustomizeDataHolder customizeDataHolder) {
        mCustomizeDataHolder = customizeDataHolder;
    }
    
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), OrderActivity.class);
        intent.putExtra(OrderActivity.KEY_JUMON, "こんにちは");
        intent.putExtra(OrderActivity.KEY_PHOTO, mCustomizeDataHolder.getCoffeePhoto());
        v.getContext().startActivity(intent);
    }
    
}
