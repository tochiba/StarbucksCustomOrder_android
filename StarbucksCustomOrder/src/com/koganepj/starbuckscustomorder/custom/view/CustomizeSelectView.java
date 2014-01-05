package com.koganepj.starbuckscustomorder.custom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Coffee;

public class CustomizeSelectView extends LinearLayout {
    
    public CustomizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_custom_customize_select_view, this, true);
    }
    
    public void setCoffeeToCreateView(Coffee coffee) {
        
    }
    
}
