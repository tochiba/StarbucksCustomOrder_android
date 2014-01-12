package com.koganepj.starbuckscustomorder.custom.view.espresso;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.model.Espresso;

public class OnEspressoCustomizeClickListener implements OnClickListener {
    
    private ArrayList<Espresso> mEspressos;
    private Espresso mSelectedEspresso;
    
    public OnEspressoCustomizeClickListener(ArrayList<Espresso> espressos) {
        mEspressos = espressos;
    }
    
    public void setSelectedEspresso(Espresso espresso) {
        mSelectedEspresso = espresso;
    }
    
    @Override
    public void onClick(View v) {
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectEspressoDialogFragment.KEY_ITEMS, mEspressos);
        if (mSelectedEspresso != null) {
            bundle.putSerializable(SelectEspressoDialogFragment.KEY_SELECTED_ITEM, mSelectedEspresso);
        }
        
        SelectEspressoDialogFragment fragment = new SelectEspressoDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
