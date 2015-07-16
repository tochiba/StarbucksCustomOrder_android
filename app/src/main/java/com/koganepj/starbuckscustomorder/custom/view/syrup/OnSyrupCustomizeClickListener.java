package com.koganepj.starbuckscustomorder.custom.view.syrup;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.model.Syrup;

public class OnSyrupCustomizeClickListener implements OnClickListener {
    
    private ArrayList<Syrup> mSyrups;
    private Syrup mSelectedSyrup;
    
    public OnSyrupCustomizeClickListener(ArrayList<Syrup> syrups) {
        mSyrups = syrups;
    }
    
    public void setSelectedSyrup(Syrup syrup) {
        mSelectedSyrup = syrup;
    }
    
    @Override
    public void onClick(View v) {
        
        //パラメータを渡す
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectSyrupDialogFragment.KEY_ITEMS, mSyrups);
        if (mSyrups != null) {
            bundle.putSerializable(SelectSyrupDialogFragment.KEY_SELECTED_ITEM, mSelectedSyrup);
        }
        
        //ダイアログの表示
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        SelectSyrupDialogFragment fragment = new SelectSyrupDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
