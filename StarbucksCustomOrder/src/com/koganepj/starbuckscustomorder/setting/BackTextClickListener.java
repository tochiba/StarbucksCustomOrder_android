package com.koganepj.starbuckscustomorder.setting;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class BackTextClickListener implements OnClickListener {
    
    private Activity mActivity;
    
    BackTextClickListener(Activity activity) {
        mActivity = activity;
    }
    
    @Override
    public void onClick(View v) {
        mActivity.onBackPressed();
    }
    
}
