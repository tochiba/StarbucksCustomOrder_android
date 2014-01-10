package com.koganepj.starbuckscustomorder.view.like;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.parse.CoffeeNameFinder;
import com.koganepj.starbuckscustomorder.view.like.matrix.MatrixSelectorLayout;

public class LikeFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, null);
        
        View settingIcon = view.findViewById(R.id.ImageSettingIcon);
        settingIcon.setOnClickListener(new SettingIconClickListener(getActivity()));
        
        MatrixSelectorLayout matrixSelectorLayout = (MatrixSelectorLayout)view.findViewById(R.id.LayoutMatrix);
        CoffeeNameFinder finder = new CoffeeNameFinder(getActivity());
        
        View okButton = view.findViewById(R.id.ButtonOk);
        okButton.setOnClickListener(new OnDecideButtonClickListener(matrixSelectorLayout, finder));
        
        return view;
    }
    
}
