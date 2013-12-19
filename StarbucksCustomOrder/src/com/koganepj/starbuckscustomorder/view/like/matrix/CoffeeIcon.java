package com.koganepj.starbuckscustomorder.view.like.matrix;

import com.koganepj.starbuckscustomorder.R;

import android.content.Context;
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
    
//    @Override
//    public void setY(float y) {
//        //中心はコーピーカップの位置のため、煙の高さを無視する
//        super.setY(y - mSteamImageView.getHeight());
//    }

}
