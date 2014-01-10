package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Temperature;

public class TempuretureSelectView extends FrameLayout {
    
    public TempuretureSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setTempureture(ArrayList<Temperature> tempuretures) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        if (tempuretures.size() == 1) { //選択なしの表示
            inflater.inflate(R.layout.layout_custom_tempureture_select_single, this);
            TextView textView = (TextView)getChildAt(0);
            
            Temperature temperature = tempuretures.get(0);
            textView.setText(temperature.getTemperature());
            return;
        }
        
        if (tempuretures.size() == 2) {
            inflater.inflate(R.layout.layout_custom_tempureture_select_multi, this);
            return;
        }
    }
    
}
