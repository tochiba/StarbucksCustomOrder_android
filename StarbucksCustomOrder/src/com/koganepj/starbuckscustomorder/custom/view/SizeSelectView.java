package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.view.support.SelectSizeMapper;
import com.koganepj.starbuckscustomorder.model.Size;

public class SizeSelectView extends RadioGroup {
    
    private SelectSizeMapper mSelectSizeMapper;
    
    public SizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSelectSizeMapper = new SelectSizeMapper();
    }
    
    public void setSize(ArrayList<Size> sizeList) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        addView(createSpaceView());
        
        for (Size size : sizeList) {
            RadioButton radioButton = (RadioButton)inflater.inflate(R.layout.layout_custom_size_select_radio, null);
            radioButton.setId(mSelectSizeMapper.getId(size));
            radioButton.setBackgroundResource(mSelectSizeMapper.getSelector(size));
            addView(radioButton);
            addView(createSpaceView());
        }
        
        ((RadioButton)getChildAt(1)).setChecked(true);
    }
    
    View createSpaceView() {
        View spaceView = new View(getContext());
        spaceView.setLayoutParams(new LayoutParams(0, 0, 1F));
        return spaceView;
    }
    

}
