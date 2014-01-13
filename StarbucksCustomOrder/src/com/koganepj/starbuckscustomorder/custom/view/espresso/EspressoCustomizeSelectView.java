package com.koganepj.starbuckscustomorder.custom.view.espresso;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.Espresso;

public class EspressoCustomizeSelectView extends FrameLayout {
    
    private ArrayList<Espresso> mEspressos;
    
    private CheckBox mCheckBox;
    private OnEspressoCustomizeClickListener mListener;
    
    public EspressoCustomizeSelectView(Context context) {
        super(context);
        
        //Viewの初期設定
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
        mCheckBox = (CheckBox)findViewById(R.id.CheckBox);
    }

    public void setEspressos(ArrayList<Espresso> espressos) {
        mEspressos = espressos;
        mListener = new OnEspressoCustomizeClickListener(espressos);
        mCheckBox.setOnClickListener(mListener);
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
    public void setSelectedEspresso(Espresso espresso) {
        if (mEspressos == null || mEspressos.size() == 0) {
            return;
        }
        
        mListener.setSelectedEspresso(espresso);
        if (mEspressos.get(0).equals(espresso)) {
            mCheckBox.setChecked(false);
            return;
        }
        
        mCheckBox.setChecked(true);
    }
    
}
