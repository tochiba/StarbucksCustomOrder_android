package com.koganepj.starbuckscustomorder.custom.view.powder;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.Powder;

class OnSelectPowderItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<Powder> mPowders;
    private DialogFragment mDialogFragment;
    
    OnSelectPowderItemClickListener(CustomActivity activity, DialogFragment dialogFragment, ArrayList<Powder> powders) {
        mCustomActivity = activity;
        mPowders = powders;
        mDialogFragment = dialogFragment;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Powder powder = mPowders.get(position);
        mCustomActivity.changePowder(powder);
        mDialogFragment.dismiss();
    }

}
