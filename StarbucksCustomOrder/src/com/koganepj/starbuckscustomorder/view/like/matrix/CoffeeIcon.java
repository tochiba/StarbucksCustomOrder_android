package com.koganepj.starbuckscustomorder.view.like.matrix;

import com.koganepj.starbuckscustomorder.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CoffeeIcon extends LinearLayout {
    
    private ImageView mImageView;
    
    public CoffeeIcon(Context context, AttributeSet attributeSet) {
        super(context);
        setOrientation(VERTICAL);
        
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_coffee_icon, this, true);
        
        mImageView = (ImageView)findViewById(R.id.ImageMatrixSelectorIcon);
    }
    
    public void setCoffeeImage(int drawable) {
        mImageView.setImageResource(drawable);
    }

}
