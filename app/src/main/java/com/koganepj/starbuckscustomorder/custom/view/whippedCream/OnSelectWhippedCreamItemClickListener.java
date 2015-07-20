package com.koganepj.starbuckscustomorder.custom.view.whippedCream;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.WhippedCream;

class OnSelectWhippedCreamItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<WhippedCream> mWhippedCreams;
    private DialogFragment mDialogFragment;
    
    OnSelectWhippedCreamItemClickListener(CustomActivity activity, DialogFragment dialogFragment, ArrayList<WhippedCream> whippedCreams) {
        mCustomActivity = activity;
        mWhippedCreams = whippedCreams;
        mDialogFragment = dialogFragment;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        WhippedCream whippedCream = mWhippedCreams.get(position);
        mCustomActivity.changeWhippedCream(whippedCream);
        mDialogFragment.dismiss();
    }

}
