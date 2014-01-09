package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class OnSingleCustomizeSelectViewClickListener implements OnClickListener {
    
    private ArrayList<String> mItems;
    
    OnSingleCustomizeSelectViewClickListener(ArrayList<String> items) {
        mItems = items;
    }
    
    @Override
    public void onClick(View v) {
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectToppingDialogFragment.KEY_ITEMS, mItems);
        
        SelectToppingDialogFragment fragment = new SelectToppingDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }

}
