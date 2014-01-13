package com.koganepj.starbuckscustomorder.order;

import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

public class SeeOrderClickListener implements OnClickListener {
    
    public static final String BASE_URL = "https://mobile.twitter.com/search?q=";
    
    private String mOrder;
    
    SeeOrderClickListener(String order) {
        mOrder = order;
    }

    @Override
    public void onClick(View v) {
        FlurryWrapper.logEvent("order_see");
        
        Uri uri = Uri.parse(BASE_URL + "%23" + mOrder);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        v.getContext().startActivity(intent);
    }

}
