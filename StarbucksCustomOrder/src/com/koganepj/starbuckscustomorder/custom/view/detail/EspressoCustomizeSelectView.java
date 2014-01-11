package com.koganepj.starbuckscustomorder.custom.view.detail;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Espresso;

public class EspressoCustomizeSelectView extends FrameLayout {

    public EspressoCustomizeSelectView(Context context) {
        super(context);
        
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom_customize_select, this);
    }

    public void setSelectEspressos(ArrayList<Espresso> items) {
        View checkBox = findViewById(R.id.CheckBox);
        checkBox.setOnClickListener(new OnEspressoCustomizeClickListener(items));
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    

}
