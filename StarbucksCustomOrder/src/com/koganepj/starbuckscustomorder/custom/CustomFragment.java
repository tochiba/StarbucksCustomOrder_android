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
import com.koganepj.starbuckscustomorder.custom.view.CustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.SizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.TempuretureSelectView;
import com.koganepj.starbuckscustomorder.model.Base;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Espresso;
import com.koganepj.starbuckscustomorder.model.Jelly;
import com.koganepj.starbuckscustomorder.parse.CalorieFinder;
import com.koganepj.starbuckscustomorder.parse.CoffeeFinder;
import com.koganepj.starbuckscustomorder.parse.PriceFinder;

public class CustomFragment extends Fragment {
    
    public static final String KEY_PARAM_COFFEENAME = "key_coffeename";
    
    private Coffee mCoffee;
    
    private CustomizeSelectView mCustomizeSelectView;
    private TextView mPriceText;
    private TextView mCalorieText;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, null);
        
        //トッピング開始時のアニメーション設定
        mCustomizeSelectView = (CustomizeSelectView)view.findViewById(R.id.LayoutCustomizeSelect);
        View sizeSelectView = view.findViewById(R.id.LayoutSizeSelect);
        View infoView = view.findViewById(R.id.LayoutInfo);
        View imageView = view.findViewById(R.id.LayoutImage);
        View toppingView = view.findViewById(R.id.ImageTopping);
        toppingView.setOnClickListener(new OnShowSelectToppingViewListener(mCustomizeSelectView, sizeSelectView, infoView, imageView));
        
        mPriceText = (TextView)view.findViewById(R.id.TextPrice);
        mCalorieText = (TextView)view.findViewById(R.id.TextCalorie);
        
        return view;
    }
    
    @Override
    public void onResume() {
        super.onResume();

        //Activityからコーヒー名を取得 ※別Activityにも属するようになれば取得方法を抽象化する
        CoffeeName coffeeName = ((CustomActivity)getActivity()).getCoffeeName();
        
        CoffeeFinder finder = new CoffeeFinder(getActivity(), coffeeName);
        mCoffee = finder.find();
        
        ((ImageView)getView().findViewById(R.id.ImageCoffee)).setImageResource(mCoffee.photo.getPhoto());
        ((TextView)getView().findViewById(R.id.TextCoffeeName)).setText(mCoffee.name.getCoffeeName());
        mPriceText.setText(mCoffee.price.getPrice() + "円");
        mCalorieText.setText(mCoffee.calorie.getCalorie() + "kcal");
        ((TempuretureSelectView)getView().findViewById(R.id.LayoutTempuretureSelect)).setTempureture(mCoffee.temperatures);
        ((SizeSelectView)getView().findViewById(R.id.LayoutSizeSelect)).setSize(mCoffee.size);
        mCustomizeSelectView.setCoffeeToCreateView(mCoffee);
    }
    
    public void changeEspresso(Espresso espresso) {
        mCustomizeSelectView.changeSelectedEspresso(espresso);
        
        PriceFinder priceFinder = new PriceFinder(getActivity());
        CalorieFinder calorieFinder = new CalorieFinder(getActivity());
        
        int espressoPrice = priceFinder.getPrice(espresso.getEspresso()).getPrice();
        int espressoCalorie = calorieFinder.getCalorie(espresso.getEspresso()).getCalorie();
        
        mPriceText.setText(mCoffee.price.getPrice() + espressoPrice + "円");
        mCalorieText.setText(mCoffee.calorie.getCalorie() + espressoCalorie + "kcal");
    }
    
    public void changeBase(Base base) {
        mCustomizeSelectView.changeSelectedBase(base);
        
        //TODO 価格とカロリーは他のトッピングも考慮しなければ！！
    }
    
    public void changeJelly(Jelly jelly) {
        mCustomizeSelectView.changeSelectedJelly(jelly);
    }
    
}
