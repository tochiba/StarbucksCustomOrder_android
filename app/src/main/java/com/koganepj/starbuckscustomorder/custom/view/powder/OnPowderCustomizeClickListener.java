package com.koganepj.starbuckscustomorder.custom.view.powder;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.model.Powder;

public class OnPowderCustomizeClickListener implements OnClickListener {
    
    private ArrayList<Powder> mPowders;
    private Powder mSelectedPowder;
    
    public OnPowderCustomizeClickListener(ArrayList<Powder> powders) {
        mPowders = powders;
    }
    
    public void setSelectedPowder(Powder powder) {
        mSelectedPowder = powder;
    }
    
    @Override
    public void onClick(View v) {
        
        //パラメータを渡す
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectPowderDialogFragment.KEY_ITEMS, mPowders);
        if (mSelectedPowder != null) {
            bundle.putSerializable(SelectPowderDialogFragment.KEY_SELECTED_ITEM, mSelectedPowder);
        }
        
        //ダイアログの表示
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        SelectPowderDialogFragment fragment = new SelectPowderDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
