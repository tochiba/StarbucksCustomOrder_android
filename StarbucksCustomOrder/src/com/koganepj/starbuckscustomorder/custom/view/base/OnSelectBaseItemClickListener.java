package com.koganepj.starbuckscustomorder.custom.view.base;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.Base;

class OnSelectBaseItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<Base> mBases;
    private DialogFragment mDialogFragment;
    
    OnSelectBaseItemClickListener(CustomActivity activity, DialogFragment dialogFragment, ArrayList<Base> bases) {
        mCustomActivity = activity;
        mBases = bases;
        mDialogFragment = dialogFragment;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Base base = mBases.get(position);
        mCustomActivity.changeBase(base);
        mDialogFragment.dismiss();
    }

}
