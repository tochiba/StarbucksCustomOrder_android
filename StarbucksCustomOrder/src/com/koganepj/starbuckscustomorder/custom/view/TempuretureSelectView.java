package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;

public class TempuretureSelectView extends FrameLayout {
    
    public TempuretureSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setTempureture(ArrayList<String> tempuretures) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        if (tempuretures.size() == 1) { //選択なしの表示
            inflater.inflate(R.layout.layout_custom_tempureture_select_single, this);
            TextView textView = (TextView)getChildAt(0);
            textView.setText(tempuretures.get(0));
            return;
        }
        
        if (tempuretures.size() == 2) {
            inflater.inflate(R.layout.layout_custom_tempureture_select_multi, this);
            return;
        }
    }
    
}
