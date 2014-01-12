package com.koganepj.starbuckscustomorder.custom.view.powder;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Powder;

public class PowderCustomizeSelectView extends FrameLayout {
    
    private ArrayList<Powder> mPowders;
    
    private CheckBox mCheckBox;
    private OnPowderCustomizeClickListener mListener;
    
    public PowderCustomizeSelectView(Context context) {
        super(context);
        
        //Viewの初期設定
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
        mCheckBox = (CheckBox)findViewById(R.id.CheckBox);
    }

    public void setPowders(ArrayList<Powder> powders) {
        mPowders = powders;
        mListener = new OnPowderCustomizeClickListener(powders);
        mCheckBox.setOnClickListener(mListener);
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
    public void setSelectedPowder(Powder powder) {
        if (mPowders == null || mPowders.size() == 0) {
            return;
        }
        
        mListener.setSelectedPowder(powder);
        if (mPowders.get(0).equals(powder)) {
            mCheckBox.setChecked(false);
            return;
        }
        
        mCheckBox.setChecked(true);
    }
    
}
