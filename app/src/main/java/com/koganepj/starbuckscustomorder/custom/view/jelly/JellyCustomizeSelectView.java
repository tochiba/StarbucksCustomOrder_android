package com.koganepj.starbuckscustomorder.custom.view.jelly;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Jelly;

public class JellyCustomizeSelectView extends FrameLayout {
    
    private ArrayList<Jelly> mJellies;
    
    private CheckBox mCheckBox;
    private OnJellyCustomizeClickListener mListener;
    
    public JellyCustomizeSelectView(Context context) {
        super(context);
        
        //Viewの初期設定
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
        mCheckBox = (CheckBox)findViewById(R.id.CheckBox);
    }
    
    public void setJellies(ArrayList<Jelly> jellies) {
        mJellies = jellies;
        mListener = new OnJellyCustomizeClickListener(mJellies);
        mCheckBox.setOnClickListener(mListener);
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
    public void setSelectedJelly(Jelly jelly) {
        if (mJellies == null || mJellies.size() == 0) {
            return;
        }
        
        mListener.setSelectedJelly(jelly);
        if (mJellies.get(0).equals(jelly)) {
            mCheckBox.setChecked(false);
            return;
        }
        
        mCheckBox.setChecked(true);
    }
    
}
