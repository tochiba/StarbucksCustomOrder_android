package com.koganepj.starbuckscustomorder.view.like;

import com.koganepj.starbuckscustomorder.setting.SettingActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class SettingIconClickListener implements OnClickListener {
    
    private Activity mActivity;
    
    public SettingIconClickListener(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mActivity, SettingActivity.class);
        mActivity.startActivity(intent);
    }
    
}
