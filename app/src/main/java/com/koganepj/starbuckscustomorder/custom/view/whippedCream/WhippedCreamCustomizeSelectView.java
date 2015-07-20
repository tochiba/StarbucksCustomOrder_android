package com.koganepj.starbuckscustomorder.custom.view.whippedCream;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.WhippedCream;

public class WhippedCreamCustomizeSelectView extends FrameLayout {
    
    private ArrayList<WhippedCream> mWhippedCreams;
    
    private CheckBox mCheckBox;
    private OnWhippedCreamCustomizeClickListener mListener;
    
    public WhippedCreamCustomizeSelectView(Context context) {
        super(context);
        
        //Viewの初期設定
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
        mCheckBox = (CheckBox)findViewById(R.id.CheckBox);
    }
    
    public void setWhippedCreams(ArrayList<WhippedCream> whippedCreams) {
        mWhippedCreams = whippedCreams;
        mListener = new OnWhippedCreamCustomizeClickListener(mWhippedCreams);
        mCheckBox.setOnClickListener(mListener);
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
    public void setSelectedWhippedCream(WhippedCream whippedCream) {
        if (mWhippedCreams == null || mWhippedCreams.size() == 0) {
            return;
        }
        
        mListener.setSelectedWhippedCream(whippedCream);
        if (mWhippedCreams.get(0).equals(whippedCream)) {
            mCheckBox.setChecked(false);
            return;
        }
        
        mCheckBox.setChecked(true);
    }
    
}
