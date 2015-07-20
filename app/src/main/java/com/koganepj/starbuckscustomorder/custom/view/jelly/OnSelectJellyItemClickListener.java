package com.koganepj.starbuckscustomorder.custom.view.jelly;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.Jelly;

class OnSelectJellyItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<Jelly> mJellies;
    private DialogFragment mDialogFragment;
    
    OnSelectJellyItemClickListener(CustomActivity activity, DialogFragment dialogFragment, ArrayList<Jelly> jellies) {
        mCustomActivity = activity;
        mJellies = jellies;
        mDialogFragment = dialogFragment;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Jelly jelly = mJellies.get(position);
        mCustomActivity.changeJelly(jelly);
        mDialogFragment.dismiss();
    }

}
