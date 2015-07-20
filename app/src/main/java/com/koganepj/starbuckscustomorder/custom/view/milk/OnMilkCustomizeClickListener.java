package com.koganepj.starbuckscustomorder.custom.view.milk;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.model.Milk;

public class OnMilkCustomizeClickListener implements OnClickListener {
    
    private ArrayList<Milk> mMilks;
    private Milk mSelectedMilk;
    
    public OnMilkCustomizeClickListener(ArrayList<Milk> milks) {
        mMilks = milks;
    }
    
    public void setSelectedMilk(Milk milk) {
        mSelectedMilk = milk;
    }
    
    @Override
    public void onClick(View v) {
        
        //パラメータを渡す
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectMilkDialogFragment.KEY_ITEMS, mMilks);
        if (mSelectedMilk != null) {
            bundle.putSerializable(SelectMilkDialogFragment.KEY_SELECTED_ITEM, mSelectedMilk);
        }
        
        //ダイアログの表示
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        SelectMilkDialogFragment fragment = new SelectMilkDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
