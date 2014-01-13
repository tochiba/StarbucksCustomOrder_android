package com.koganepj.starbuckscustomorder.custom.view.sauce;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.Sauce;

public class SauceCustomizeSelectView extends FrameLayout {
    
    private ArrayList<Sauce> mSauces;
    
    private CheckBox mCheckBox;
    private OnSauceCustomizeClickListener mListener;
    
    public SauceCustomizeSelectView(Context context) {
        super(context);
        
        //Viewの初期設定
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
        mCheckBox = (CheckBox)findViewById(R.id.CheckBox);
    }

    public void setSauces(ArrayList<Sauce> sauces) {
        mSauces = sauces;
        mListener = new OnSauceCustomizeClickListener(sauces);
        mCheckBox.setOnClickListener(mListener);
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
    public void setSelectedSauce(Sauce sauce) {
        if (mSauces == null || mSauces.size() == 0) {
            return;
        }
        
        mListener.setSelectedSauce(sauce);
        if (mSauces.get(0).equals(sauce)) {
            mCheckBox.setChecked(false);
            return;
        }
        
        mCheckBox.setChecked(true);
    }
    
}
