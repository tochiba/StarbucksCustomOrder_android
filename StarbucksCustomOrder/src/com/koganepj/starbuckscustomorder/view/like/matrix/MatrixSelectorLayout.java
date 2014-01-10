package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Hotness;
import com.koganepj.starbuckscustomorder.model.Sweetness;

public class MatrixSelectorLayout extends FrameLayout {
    
    public static final int NUMBER_OF_STAGE = 5;//何段階で値を取得するのか
    
    private CoffeeIcon mCoffeeIcon;
    private View mBackgroundView;
    
    public MatrixSelectorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        //レイアウトを読み込み
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_selector, this, true);
        
        //ドラッグアンドドロップの設定
        mBackgroundView = findViewById(R.id.ImageMatrixSelectorBackground);
        mCoffeeIcon = (CoffeeIcon)getChildAt(1);//IDでひけないのでしかたなく。
        CoffeeImageChanger coffeeImageChanger = new CoffeeImageChanger(mCoffeeIcon);
        CoffeeSteamVisibilityChanger coffeeSteamVisibilityChanger = new CoffeeSteamVisibilityChanger(mCoffeeIcon);
        mBackgroundView.setOnTouchListener(new OnMatrixTouchListener(mCoffeeIcon, coffeeImageChanger, coffeeSteamVisibilityChanger));
        
        //表示サイズの動的調整
        getViewTreeObserver().addOnGlobalLayoutListener(new ExpandBackgroundSizeOnGlobalLayoutListener(this, mCoffeeIcon));
    }
    
    public Sweetness getSweetness() {
        int sweetnessValue = calcLevel(mBackgroundView.getWidth(), (int)mCoffeeIcon.getX());
        return new Sweetness(sweetnessValue);
    }
    
    public Hotness getHotness() {
        int hotnessValue = calcLevel(mBackgroundView.getHeight(), (int)mCoffeeIcon.getY());
        return new Hotness(hotnessValue);
    }
    
    int calcLevel(int parentValue, int currentValue) {
        if (parentValue == currentValue) {
            return NUMBER_OF_STAGE - 1;
        }
        
        int baseValue = parentValue / NUMBER_OF_STAGE;
        return currentValue / baseValue;
    }
}
