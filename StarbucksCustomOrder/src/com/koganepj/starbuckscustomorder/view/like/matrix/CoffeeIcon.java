package com.koganepj.starbuckscustomorder.view.like.matrix;

import com.koganepj.starbuckscustomorder.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class CoffeeIcon extends LinearLayout {

    public CoffeeIcon(Context context, AttributeSet attributeSet) {
        super(context);
        
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_coffee_icon, this, true);
    }

}
