package com.koganepj.starbuckscustomorder.custom.view.sauce;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.model.Sauce;

public class OnSauceCustomizeClickListener implements OnClickListener {
    
    private ArrayList<Sauce> mSauces;
    private Sauce mSelectedSauce;
    
    public OnSauceCustomizeClickListener(ArrayList<Sauce> sauces) {
        mSauces = sauces;
    }
    
    public void setSelectedSauce(Sauce sauce) {
        mSelectedSauce = sauce;
    }
    
    @Override
    public void onClick(View v) {
        
        //パラメータを渡す
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectSauceDialogFragment.KEY_ITEMS, mSauces);
        if (mSelectedSauce != null) {
            bundle.putSerializable(SelectSauceDialogFragment.KEY_SELECTED_ITEM, mSelectedSauce);
        }
        
        //ダイアログの表示
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        SelectSauceDialogFragment fragment = new SelectSauceDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
