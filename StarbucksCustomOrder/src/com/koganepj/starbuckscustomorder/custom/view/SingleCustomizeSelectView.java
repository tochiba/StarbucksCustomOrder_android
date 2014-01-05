package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.koganepj.starbuckscustomorder.R;

public class SingleCustomizeSelectView extends LinearLayout {

    public SingleCustomizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //layout_custom_customize_selectレイアウトを使用する場合を想定した実装になっています
    }
    
    public void setSelectItems(final ArrayList<String> items) {
        findViewById(R.id.CheckBox).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "選択項目：" + items, Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    public void setText(String text) {
        ((TextView)findViewById(R.id.TextCustomizeDetail)).setText(text);
    }
    
}
