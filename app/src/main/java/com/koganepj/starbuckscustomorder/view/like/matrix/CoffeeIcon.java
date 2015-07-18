package com.koganepj.starbuckscustomorder.view.like.matrix;

import com.koganepj.starbuckscustomorder.free.R;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CoffeeIcon extends LinearLayout {
    
    private ImageView mCoffeeImageView;
    private ImageView mSteamImageView;
    
    public CoffeeIcon(Context context, AttributeSet attributeSet) {
        super(context);
        setOrientation(VERTICAL);
        
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_coffee_icon, this, true);
        
        mCoffeeImageView = (ImageView)findViewById(R.id.ImageMatrixSelectorIcon);
        mSteamImageView = (ImageView)findViewById(R.id.ImageMatrixSelectorIconSteam);
        
        //アニメーションの開始
        mSteamImageView.setBackgroundResource(R.drawable.animation_matrix_coffee_steam);
        AnimationDrawable animationDrawable = (AnimationDrawable)mSteamImageView.getBackground();
        animationDrawable.start();
    }
    
    public int getCoffeeIconHeight() {
        return mCoffeeImageView.getHeight();
    }
    
    public int getCoffeeIconWidth() {
        return mCoffeeImageView.getWidth();
    }
    
    public int getSteamHeight() {
        return mSteamImageView.getHeight();
    }
    
    public void setCoffeeImage(int drawable) {
        mCoffeeImageView.setImageResource(drawable);
    }
    
    public void startSteamAnimation() {
        mSteamImageView.setVisibility(VISIBLE);
    }
    
    public void stopSteamAnimation() {
        mSteamImageView.setVisibility(INVISIBLE);
    }
    
}
