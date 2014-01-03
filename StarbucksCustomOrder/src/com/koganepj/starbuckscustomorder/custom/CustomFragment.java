package com.koganepj.starbuckscustomorder.custom;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.animation.OnShowSelectToppingViewListener;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.parse.CoffeeFinder;

public class CustomFragment extends Fragment {
    
    public static final String KEY_PARAM_COFFEENAME = "key_coffeename";
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, null);
        
        View toppingSelectView = view.findViewById(R.id.LayoutToppingSelect);
        View sizeSelectView = view.findViewById(R.id.LayoutSizeSelect);
        View infoView = view.findViewById(R.id.LayoutInfo);
        View imageView = view.findViewById(R.id.LayoutImage);
        
        //トッピング開始時のアニメーション設定
        View toppingView = view.findViewById(R.id.ImageTopping);
        toppingView.setOnClickListener(new OnShowSelectToppingViewListener(toppingSelectView, sizeSelectView, infoView, imageView));
        
        return view;
    }
    
    @Override
    public void onResume() {
        super.onResume();

        //Activityからコーヒー名を取得 ※別Activityにも属するようになれば取得方法を抽象化する
        CoffeeName coffeeName = ((CustomActivity)getActivity()).getCoffeeName();
        
        CoffeeFinder finder = new CoffeeFinder(getActivity(), coffeeName);
        Coffee coffee = finder.find();
        
        ((ImageView)getView().findViewById(R.id.ImageCoffee)).setImageResource(coffee.photo.getPhoto());
        ((TextView)getView().findViewById(R.id.TextCoffeeName)).setText(coffee.name.getCoffeeName());
    }
    
}
