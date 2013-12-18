package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.koganepj.starbuckscustomorder.R;

public class MatrixSelectorLayout extends FrameLayout {

    public MatrixSelectorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        //レイアウトを読み込み
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_selector, this, true);
        
        //ドラッグアンドドロップの設定
        View backgroundView = findViewById(R.id.ImageMatrixSelectorBackground);
        ImageView iconView = (ImageView)findViewById(R.id.ImageMatrixSelectorIcon);
        CoffeeImageChanger changer = new CoffeeImageChanger(iconView);
        backgroundView.setOnTouchListener(new OnMatrixTouchListener(iconView, changer));
        
        //表示サイズの動的調整
        getViewTreeObserver().addOnGlobalLayoutListener(new ExpandBackgroundSizeOnGlobalLayoutListener(this));
    }

}
