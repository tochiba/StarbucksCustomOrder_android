package com.koganepj.starbuckscustomorder.custom.view.jelly;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.model.Jelly;

public class OnJellyCustomizeClickListener implements OnClickListener {
    
    private ArrayList<Jelly> mJellies;
    private Jelly mSelectedJelly;
    
    public OnJellyCustomizeClickListener(ArrayList<Jelly> jellies) {
        mJellies = jellies;
    }
    
    public void setSelectedJelly(Jelly jelly) {
        mSelectedJelly = jelly;
    }
    
    @Override
    public void onClick(View v) {
        
        //パラメータを渡す
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectJellyDialogFragment.KEY_ITEMS, mJellies);
        if (mJellies != null) {
            bundle.putSerializable(SelectJellyDialogFragment.KEY_SELECTED_ITEM, mSelectedJelly);
        }
        
        //ダイアログの表示
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        SelectJellyDialogFragment fragment = new SelectJellyDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
