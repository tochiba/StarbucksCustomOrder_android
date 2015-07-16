package com.koganepj.starbuckscustomorder.custom.view.syrup;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Syrup;

public class SyrupCustomizeSelectView extends FrameLayout {
    
    private ArrayList<Syrup> mSyrups;
    
    private CheckBox mCheckBox;
    private OnSyrupCustomizeClickListener mListener;
    
    public SyrupCustomizeSelectView(Context context) {
        super(context);
        
        //Viewの初期設定
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
        mCheckBox = (CheckBox)findViewById(R.id.CheckBox);
    }
    
    public void setSyrups(ArrayList<Syrup> syrups) {
        mSyrups = syrups;
        mListener = new OnSyrupCustomizeClickListener(mSyrups);
        mCheckBox.setOnClickListener(mListener);
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
    public void setSelectedSyrup(Syrup syrup) {
        if (mSyrups == null || mSyrups.size() == 0) {
            return;
        }
        
        mListener.setSelectedSyrup(syrup);
        if (mSyrups.get(0).equals(syrup)) {
            mCheckBox.setChecked(false);
            return;
        }
        
        mCheckBox.setChecked(true);
    }
    
}
