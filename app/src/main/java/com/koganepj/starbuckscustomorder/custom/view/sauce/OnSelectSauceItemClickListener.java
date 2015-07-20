package com.koganepj.starbuckscustomorder.custom.view.sauce;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.Sauce;

class OnSelectSauceItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<Sauce> mSauces;
    private DialogFragment mDialogFragment;
    
    OnSelectSauceItemClickListener(CustomActivity activity, DialogFragment dialogFragment, ArrayList<Sauce> sauces) {
        mCustomActivity = activity;
        mSauces = sauces;
        mDialogFragment = dialogFragment;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Sauce sauce = mSauces.get(position);
        mCustomActivity.changeSauce(sauce);
        mDialogFragment.dismiss();
    }

}
