package com.koganepj.starbuckscustomorder.custom;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.animation.OnShowSelectToppingViewListener;
import com.koganepj.starbuckscustomorder.custom.view.CustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.SizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.SizeSelectView.OnChangeSizeListener;
import com.koganepj.starbuckscustomorder.custom.view.TempuretureSelectView;
import com.koganepj.starbuckscustomorder.model.Base;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Espresso;
import com.koganepj.starbuckscustomorder.model.Jelly;
import com.koganepj.starbuckscustomorder.model.Milk;
import com.koganepj.starbuckscustomorder.model.Powder;
import com.koganepj.starbuckscustomorder.model.Sauce;
import com.koganepj.starbuckscustomorder.model.Size;
import com.koganepj.starbuckscustomorder.model.Syrup;
import com.koganepj.starbuckscustomorder.model.WhippedCream;
import com.koganepj.starbuckscustomorder.parse.CalorieFinder;
import com.koganepj.starbuckscustomorder.parse.CoffeeFinder;
import com.koganepj.starbuckscustomorder.parse.PriceFinder;

public class CustomFragment extends Fragment implements OnChangeSizeListener {
    
    public static final String KEY_PARAM_COFFEENAME = "key_coffeename";
    
    private CustomizeDataHolder mCustomizeDataHolder;
    
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
        
        if (mCustomizeDataHolder != null) {
            return;
        }

        //Activityからコーヒー名を取得 ※別Activityにも属するようになれば取得方法を抽象化する
        CoffeeName coffeeName = ((CustomActivity)getActivity()).getCoffeeName();
        
        CoffeeFinder finder = new CoffeeFinder(getActivity(), coffeeName);
        Coffee coffee = finder.find();
        mCustomizeDataHolder = new CustomizeDataHolder(coffee, new PriceFinder(getActivity()), new CalorieFinder(getActivity()));
        
        ((ImageView)getView().findViewById(R.id.ImageCoffee)).setImageResource(coffee.photo.getPhoto());
        ((TextView)getView().findViewById(R.id.TextCoffeeName)).setText(coffee.name.getCoffeeName());
        mPriceText.setText(coffee.price.getPrice() + "円");
        mCalorieText.setText(coffee.calorie.getCalorie() + "kcal");
        ((TempuretureSelectView)getView().findViewById(R.id.LayoutTempuretureSelect)).setTempureture(coffee.temperatures);
        ((SizeSelectView)getView().findViewById(R.id.LayoutSizeSelect)).setSize(coffee.size);
        ((SizeSelectView)getView().findViewById(R.id.LayoutSizeSelect)).setOnChangeSizeListener(this);
        mCustomizeSelectView.setCoffeeToCreateView(coffee);
    }
    
    public void changeEspresso(Espresso espresso) {
        mCustomizeSelectView.changeSelectedEspresso(espresso);
        
        mCustomizeDataHolder.changeEspresso(espresso);
        
        mCalorieText.setText(mCustomizeDataHolder.getCalorie() + "kcal");
        mPriceText.setText(mCustomizeDataHolder.getPrice() + "円");
    }
    
    public void changeBase(Base base) {
        mCustomizeSelectView.changeSelectedBase(base);
        
        mCustomizeDataHolder.changeBase(base);
        
        mCalorieText.setText(mCustomizeDataHolder.getCalorie() + "kcal");
        mPriceText.setText(mCustomizeDataHolder.getPrice() + "円");
    }
    
    public void changeJelly(Jelly jelly) {
        mCustomizeSelectView.changeSelectedJelly(jelly);
        
        mCustomizeDataHolder.changeJelly(jelly);
        
        mCalorieText.setText(mCustomizeDataHolder.getCalorie() + "kcal");
        mPriceText.setText(mCustomizeDataHolder.getPrice() + "円");
    }
    
    public void changeMilk(Milk milk) {
        mCustomizeSelectView.changeSelectedMilk(milk);
        
        mCustomizeDataHolder.changeMilk(milk);
        
        mCalorieText.setText(mCustomizeDataHolder.getCalorie() + "kcal");
        mPriceText.setText(mCustomizeDataHolder.getPrice() + "円");
    }
    
    public void changePowder(Powder powder) {
        mCustomizeSelectView.changeSelectedPowder(powder);
        
        mCustomizeDataHolder.changePowder(powder);
        
        mCalorieText.setText(mCustomizeDataHolder.getCalorie() + "kcal");
        mPriceText.setText(mCustomizeDataHolder.getPrice() + "円");
    }
    
    public void changeSauce(Sauce sauce) {
        mCustomizeSelectView.changeSelectedSauce(sauce);
        
        mCustomizeDataHolder.changeSauce(sauce);
        
        mCalorieText.setText(mCustomizeDataHolder.getCalorie() + "kcal");
        mPriceText.setText(mCustomizeDataHolder.getPrice() + "円");
    }
    
    public void changeSyrup(Syrup syrup) {
        mCustomizeSelectView.changeSelectedSyrup(syrup);
        
        mCustomizeDataHolder.changeSyrup(syrup);
        
        mCalorieText.setText(mCustomizeDataHolder.getCalorie() + "kcal");
        mPriceText.setText(mCustomizeDataHolder.getPrice() + "円");
    }
    
    public void changeWhippedCream(WhippedCream whippedCream) {
        mCustomizeSelectView.changeSelectedWhippedCream(whippedCream);
        
        mCustomizeDataHolder.changeWhippedCream(whippedCream);
        
        mCalorieText.setText(mCustomizeDataHolder.getCalorie() + "kcal");
        mPriceText.setText(mCustomizeDataHolder.getPrice() + "円");
    }

    @Override
    public void changeSize(Size size) {
        Log.d("test", "size : " + size.getSize());
    }
    
}
