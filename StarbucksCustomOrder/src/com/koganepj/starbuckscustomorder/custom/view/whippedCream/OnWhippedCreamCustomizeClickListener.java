package com.koganepj.starbuckscustomorder.custom.view.whippedCream;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.model.WhippedCream;

public class OnWhippedCreamCustomizeClickListener implements OnClickListener {
    
    private ArrayList<WhippedCream> mWhippedCreams;
    private WhippedCream mSelectedWhippedCream;
    
    public OnWhippedCreamCustomizeClickListener(ArrayList<WhippedCream> whippedCreams) {
        mWhippedCreams = whippedCreams;
    }
    
    public void setSelectedWhippedCream(WhippedCream whippedCream) {
        mSelectedWhippedCream = whippedCream;
    }
    
    @Override
    public void onClick(View v) {
        
        //パラメータを渡す
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectWhippedCreamDialogFragment.KEY_ITEMS, mWhippedCreams);
        if (mWhippedCreams != null) {
            bundle.putSerializable(SelectWhippedCreamDialogFragment.KEY_SELECTED_ITEM, mSelectedWhippedCream);
        }
        
        //ダイアログの表示
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        SelectWhippedCreamDialogFragment fragment = new SelectWhippedCreamDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
