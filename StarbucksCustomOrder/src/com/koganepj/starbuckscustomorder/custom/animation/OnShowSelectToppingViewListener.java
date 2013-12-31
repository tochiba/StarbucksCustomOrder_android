package com.koganepj.starbuckscustomorder.custom.animation;

import com.koganepj.starbuckscustomorder.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class OnShowSelectToppingViewListener implements OnClickListener {
    
    private View mSelectToppingView;
    private View mSizeSelectView;
    
    public OnShowSelectToppingViewListener(View selecToppingView, View sizeSelectView) {
        mSelectToppingView = selecToppingView;
        mSizeSelectView = sizeSelectView;
    }
    
    @Override
    public void onClick(View v) {
        Animation selectToppingAnimation = AnimationUtils.loadAnimation(v.getContext(), R.anim.animation_select_topping_view);
        mSelectToppingView.setVisibility(View.VISIBLE);
        mSelectToppingView.startAnimation(selectToppingAnimation);
        
        Animation sizeSelectAnimation = AnimationUtils.loadAnimation(v.getContext(), R.anim.animation_size_select_view);
        mSizeSelectView.startAnimation(sizeSelectAnimation);
    }

}
