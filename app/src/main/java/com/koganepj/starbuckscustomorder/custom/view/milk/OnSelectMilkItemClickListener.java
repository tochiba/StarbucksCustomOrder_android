package com.koganepj.starbuckscustomorder.custom.view.milk;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.Milk;

class OnSelectMilkItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<Milk> mMilks;
    private DialogFragment mDialogFragment;
    
    OnSelectMilkItemClickListener(CustomActivity activity, DialogFragment dialogFragment, ArrayList<Milk> milks) {
        mCustomActivity = activity;
        mMilks = milks;
        mDialogFragment = dialogFragment;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Milk milk = mMilks.get(position);
        mCustomActivity.changeMilk(milk);
        mDialogFragment.dismiss();
    }

}
