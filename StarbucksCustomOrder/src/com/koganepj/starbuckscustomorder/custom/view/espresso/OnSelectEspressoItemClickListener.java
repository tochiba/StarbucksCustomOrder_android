package com.koganepj.starbuckscustomorder.custom.view.espresso;

import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.model.Espresso;

class OnSelectEspressoItemClickListener implements OnItemClickListener {
    
    private CustomActivity mCustomActivity; //ほんとは抽象的な型にしたい！
    private ArrayList<Espresso> mEspressos;
    
    OnSelectEspressoItemClickListener(CustomActivity activity, ArrayList<Espresso> espressos) {
        mCustomActivity = activity;
        mEspressos = espressos;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Espresso espresso = mEspressos.get(position);
        mCustomActivity.changeEspresso(espresso);
    }

}
