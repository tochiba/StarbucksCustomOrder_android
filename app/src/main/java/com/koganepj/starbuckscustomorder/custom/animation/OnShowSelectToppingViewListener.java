package com.koganepj.starbuckscustomorder.custom.animation;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.BounceInterpolator;

import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;

public class OnShowSelectToppingViewListener implements OnClickListener {
    
    private View mParentView;
    private View mToppingSelectView;
    private View mSizeSelectView;
    private View mInfoView;
    private View mImageView;
    
    public OnShowSelectToppingViewListener(View parentView, View selecToppingView, View sizeSelectView, View infoView, View imageView) {
        mParentView = parentView;
        mToppingSelectView = selecToppingView;
        mSizeSelectView = sizeSelectView;
        mInfoView = infoView;
        mImageView = imageView;
    }
    
    @Override
    public void onClick(View v) {
        FlurryWrapper.logEvent("custom_start_customize");
        
        //アニメーションにつかう値を取得しておく
        int duration = 1000;
        BounceInterpolator interpolator = new BounceInterpolator();
        int sizeSelectViewHeight = mSizeSelectView.getHeight();
        int infoViewHeight = mInfoView.getHeight();
        int imageViewHeight = mImageView.getHeight();
        int mParentViewHeight = mParentView.getHeight();
        
        mToppingSelectView.setVisibility(View.VISIBLE);
        ObjectAnimator selectToppingAnimator = ObjectAnimator.ofFloat(mToppingSelectView, "y", -500f, 20f);
        selectToppingAnimator.setDuration(duration);
        selectToppingAnimator.setInterpolator(interpolator);
        selectToppingAnimator.start();
        
        ObjectAnimator sizeSelectAnimator = ObjectAnimator.ofFloat(mSizeSelectView, "y", mSizeSelectView.getTop(), mParentViewHeight - sizeSelectViewHeight - 100);
        sizeSelectAnimator.setDuration(duration);
        sizeSelectAnimator.setInterpolator(interpolator);
        sizeSelectAnimator.start();
        
        ObjectAnimator infoAnimator = ObjectAnimator.ofFloat(mInfoView, "y", mInfoView.getTop(), mParentViewHeight - infoViewHeight - sizeSelectViewHeight - 120);
        infoAnimator.setDuration(duration);
        infoAnimator.setInterpolator(interpolator);
        infoAnimator.start();
        
        ObjectAnimator imageAnimator = ObjectAnimator.ofFloat(mImageView, "y", mImageView.getTop(), mParentViewHeight - imageViewHeight - infoViewHeight - sizeSelectViewHeight - 140);
        imageAnimator.setDuration(duration);
        imageAnimator.setInterpolator(interpolator);
        imageAnimator.start();
    }

}
