package com.koganepj.starbuckscustomorder.custom.view.syrup;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.Syrup;

class OnSelectSyrupItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<Syrup> mSyrups;
    private DialogFragment mDialogFragment;
    
    OnSelectSyrupItemClickListener(CustomActivity activity, DialogFragment dialogFragment, ArrayList<Syrup> syrups) {
        mCustomActivity = activity;
        mSyrups = syrups;
        mDialogFragment = dialogFragment;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Syrup syrup = mSyrups.get(position);
        mCustomActivity.changeSyrup(syrup);
        mDialogFragment.dismiss();
    }

}
