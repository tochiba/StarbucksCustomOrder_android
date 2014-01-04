package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.view.support.SelectSizeMapper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SizeSelectView extends RadioGroup {
    
    private SelectSizeMapper mSelectSizeMapper;
    
    public SizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSelectSizeMapper = new SelectSizeMapper();
    }
    
    public void setSize(ArrayList<String> sizeList) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        for (String sizeStr : sizeList) {
            RadioButton radioButton = (RadioButton)inflater.inflate(R.layout.layout_custom_size_select_radio, null);
            radioButton.setText(sizeStr);
            radioButton.setId(mSelectSizeMapper.getId(sizeStr));
            addView(radioButton);
        }
    }
    

}
