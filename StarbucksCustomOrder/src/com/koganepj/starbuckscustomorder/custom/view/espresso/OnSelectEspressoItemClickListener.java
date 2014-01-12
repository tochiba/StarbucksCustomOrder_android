package com.koganepj.starbuckscustomorder.custom.view.espresso;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.Espresso;

class OnSelectEspressoItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<Espresso> mEspressos;
    private DialogFragment mDialogFragment;
    
    OnSelectEspressoItemClickListener(CustomActivity activity, DialogFragment dialogFragment, ArrayList<Espresso> espressos) {
        mCustomActivity = activity;
        mEspressos = espressos;
        mDialogFragment = dialogFragment;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Espresso espresso = mEspressos.get(position);
        mCustomActivity.changeEspresso(espresso);
        mDialogFragment.dismiss();
    }

}
