package com.koganepj.starbuckscustomorder.custom;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.animation.OnShowSelectToppingViewListener;
import com.koganepj.starbuckscustomorder.model.CoffeeName;

public class CustomFragment extends Fragment {
    
    public static final String KEY_PARAM_COFFEENAME = "key_coffeename";
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, null);
        
        View toppingSelectView = view.findViewById(R.id.LayoutToppingSelect);
        View sizeSelectView = view.findViewById(R.id.LayoutSizeSelect);
        View infoView = view.findViewById(R.id.LayoutInfo);
        View imageView = view.findViewById(R.id.LayoutImage);
        
        //パラメータを受け取って表示要素の設定
//        CoffeeName coffeeName = (CoffeeName)getArguments().getSerializable(KEY_PARAM_COFFEENAME);
//        Log.d("test", "fragment get coffe name : " + coffeeName.getCoffeeName());
        
        //トッピング開始時のアニメーション設定
        View toppingView = view.findViewById(R.id.ImageTopping);
        toppingView.setOnClickListener(new OnShowSelectToppingViewListener(toppingSelectView, sizeSelectView, infoView, imageView));
        
        return view;
    }
    
}
