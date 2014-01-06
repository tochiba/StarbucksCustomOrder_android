package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class OnSingleCustomizeSelectViewClickListener implements OnClickListener {
    
    private ArrayList<String> mItems;
    
    OnSingleCustomizeSelectViewClickListener(ArrayList<String> items) {
        mItems = items;
    }
    
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "選択項目：" + mItems, Toast.LENGTH_SHORT).show();
    }

}
