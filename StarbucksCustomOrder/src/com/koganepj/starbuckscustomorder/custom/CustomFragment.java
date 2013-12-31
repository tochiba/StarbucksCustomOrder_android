package com.koganepj.starbuckscustomorder.custom;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.animation.OnShowSelectToppingViewListener;

public class CustomFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, null);
        
        View toppingSelectView = view.findViewById(R.id.LayoutToppingSelect);
        View sizeSelectView = view.findViewById(R.id.LayoutSizeSelect);
        View infoView = view.findViewById(R.id.LayoutInfo);
        
        //トッピング開始
        View toppingView = view.findViewById(R.id.ImageTopping);
        toppingView.setOnClickListener(new OnShowSelectToppingViewListener(toppingSelectView, sizeSelectView, infoView));
        
        return view;
    }
    
}
