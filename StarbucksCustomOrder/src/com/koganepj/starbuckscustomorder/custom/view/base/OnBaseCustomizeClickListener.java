package com.koganepj.starbuckscustomorder.custom.view.base;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.model.Base;

public class OnBaseCustomizeClickListener implements OnClickListener {
    
    private ArrayList<Base> mBases;
    private Base mSelectedBase;
    
    public OnBaseCustomizeClickListener(ArrayList<Base> bases) {
        mBases = bases;
    }
    
    public void setSelectedBase(Base base) {
        mSelectedBase = base;
    }
    
    @Override
    public void onClick(View v) {
        
        //パラメータを渡す
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectBaseDialogFragment.KEY_ITEMS, mBases);
        if (mBases != null) {
            bundle.putSerializable(SelectBaseDialogFragment.KEY_SELECTED_ITEM, mSelectedBase);
        }
        
        //ダイアログの表示
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        SelectBaseDialogFragment fragment = new SelectBaseDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
