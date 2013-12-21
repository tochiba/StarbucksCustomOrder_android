package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.koganepj.starbuckscustomorder.R;

public class MatrixSelectorLayout extends FrameLayout {

    public MatrixSelectorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        //レイアウトを読み込み
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_selector, this, true);
        
        //ドラッグアンドドロップの設定
        View backgroundView = findViewById(R.id.ImageMatrixSelectorBackground);
        CoffeeIcon coffeeIcon = (CoffeeIcon)getChildAt(1);//IDでひけないのでしかたなく。
        CoffeeImageChanger coffeeImageChanger = new CoffeeImageChanger(coffeeIcon);
        CoffeeSteamVisibilityChanger coffeeSteamVisibilityChanger = new CoffeeSteamVisibilityChanger(coffeeIcon);
        backgroundView.setOnTouchListener(new OnMatrixTouchListener(coffeeIcon, coffeeImageChanger, coffeeSteamVisibilityChanger));
        
        //表示サイズの動的調整
        getViewTreeObserver().addOnGlobalLayoutListener(new ExpandBackgroundSizeOnGlobalLayoutListener(this, coffeeIcon));
    }

}
