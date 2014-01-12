package com.koganepj.starbuckscustomorder.custom.view.base;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Base;

public class BaseCustomizeSelectView extends FrameLayout {
    
    private ArrayList<Base> mBases;
    
    private CheckBox mCheckBox;
    private OnBaseCustomizeClickListener mListener;
    
    public BaseCustomizeSelectView(Context context) {
        super(context);
        
        //Viewの初期設定
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
        mCheckBox = (CheckBox)findViewById(R.id.CheckBox);
    }
    
    public void setBases(ArrayList<Base> bases) {
        mBases = bases;
        mListener = new OnBaseCustomizeClickListener(mBases);
        mCheckBox.setOnClickListener(mListener);
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
    public void setSelectedBase(Base base) {
        if (mBases == null || mBases.size() == 0) {
            return;
        }
        
        mListener.setSelectedBase(base);
        if (mBases.get(0).equals(base)) {
            mCheckBox.setChecked(false);
            return;
        }
        
        mCheckBox.setChecked(true);
    }
    
}
