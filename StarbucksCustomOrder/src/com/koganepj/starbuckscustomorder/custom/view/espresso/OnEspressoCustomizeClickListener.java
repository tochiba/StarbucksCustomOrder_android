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
    
    public OnEspressoCustomizeClickListener(ArrayList<Espresso> espressos) {
        mEspressos = espressos;
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = ((Activity)v.getContext()).getFragmentManager();
        
        Bundle bundle = new Bundle();
        bundle.putSerializable(SelectEspressoDialogFragment.KEY_ITEMS, mEspressos);
        
        SelectEspressoDialogFragment fragment = new SelectEspressoDialogFragment();
        fragment.setArguments(bundle);
        fragment.show(manager, null);
    }
    
}
