package com.koganepj.starbuckscustomorder.custom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Coffee;

public class CustomizeSelectView extends LinearLayout {
    
    public CustomizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_custom_customize_select_view, this, true);
    }
    
    public void setCoffeeToCreateView(Coffee coffee) {
        GridLayout grid = (GridLayout)findViewById(R.id.GridLayout);
        
        if (coffee.base.size() != 0) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_customize_select, null);
            ((TextView)view.findViewById(R.id.TextCustomizeDetail)).setText("Base");
            grid.addView(view);
        }
        
        if (coffee.espresso.size() != 0) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_customize_select, null);
            ((TextView)view.findViewById(R.id.TextCustomizeDetail)).setText("Espresso");
            grid.addView(view);
        }

        if (coffee.jelly.size() != 0) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_customize_select, null);
            ((TextView)view.findViewById(R.id.TextCustomizeDetail)).setText("Jelly");
            grid.addView(view);
        }

        if (coffee.milk.size() != 0) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_customize_select, null);
            ((TextView)view.findViewById(R.id.TextCustomizeDetail)).setText("Milk");
            grid.addView(view);
        }

        if (coffee.powder.size() != 0) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_customize_select, null);
            ((TextView)view.findViewById(R.id.TextCustomizeDetail)).setText("Powder");
            grid.addView(view);
        }

        if (coffee.sauce.size() != 0) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_customize_select, null);
            ((TextView)view.findViewById(R.id.TextCustomizeDetail)).setText("Sauce");
            grid.addView(view);
        }

        if (coffee.syrup.size() != 0) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_customize_select, null);
            ((TextView)view.findViewById(R.id.TextCustomizeDetail)).setText("Syrup");
            grid.addView(view);
        }

        if (coffee.whippedCream.size() != 0) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_customize_select, null);
            ((TextView)view.findViewById(R.id.TextCustomizeDetail)).setText("WhippedCream");
            grid.addView(view);
        }
    }
    
}
