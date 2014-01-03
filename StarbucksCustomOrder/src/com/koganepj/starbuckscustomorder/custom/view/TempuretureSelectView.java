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
        //選択なしの表示
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_tempureture_select_single, this);
        
        TextView textView = (TextView)getChildAt(0);
        textView.setText(tempuretures.get(0));
    }
    
}
