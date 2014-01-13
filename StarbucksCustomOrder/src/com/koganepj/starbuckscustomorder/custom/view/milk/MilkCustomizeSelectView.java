package com.koganepj.starbuckscustomorder.custom.view.milk;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.Milk;

public class MilkCustomizeSelectView extends FrameLayout {
    
    private ArrayList<Milk> mMilks;
    
    private CheckBox mCheckBox;
    private OnMilkCustomizeClickListener mListener;
    
    public MilkCustomizeSelectView(Context context) {
        super(context);
        
        //Viewの初期設定
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
        mCheckBox = (CheckBox)findViewById(R.id.CheckBox);
    }

    public void setMilks(ArrayList<Milk> milks) {
        mMilks = milks;
        mListener = new OnMilkCustomizeClickListener(milks);
        mCheckBox.setOnClickListener(mListener);
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
    public void setSelectedMilk(Milk milk) {
        if (mMilks == null || mMilks.size() == 0) {
            return;
        }
        
        mListener.setSelectedMilk(milk);
        if (mMilks.get(0).equals(milk)) {
            mCheckBox.setChecked(false);
            return;
        }
        
        mCheckBox.setChecked(true);
    }
    
}
