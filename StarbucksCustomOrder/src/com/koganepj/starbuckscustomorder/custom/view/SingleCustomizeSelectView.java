package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;

public class SingleCustomizeSelectView extends LinearLayout {

    public SingleCustomizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //layout_custom_customize_selectレイアウトを使用する場合を想定した実装になっています
    }
    
    public void setSelectItems(ArrayList<String> items) {
        View checkBox = findViewById(R.id.CheckBox);
        checkBox.setOnClickListener(new OnSingleCustomizeSelectViewClickListener(items));
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
}
