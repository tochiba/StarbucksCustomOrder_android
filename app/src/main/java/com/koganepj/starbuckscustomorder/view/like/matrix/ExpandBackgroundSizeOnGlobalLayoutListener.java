package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/**
 * ドラッグする画像のサイズに合わせて背景サイズの拡張を行うクラスです
 * @author shoma2da
 */
class ExpandBackgroundSizeOnGlobalLayoutListener implements OnGlobalLayoutListener {
    
    private MatrixSelectorLayout mLayout;
    private CoffeeIcon mCoffeeIcon;
    
    public ExpandBackgroundSizeOnGlobalLayoutListener(MatrixSelectorLayout layout, CoffeeIcon coffeeIcon) {
        mLayout = layout;
        mCoffeeIcon = coffeeIcon;
    }
    
    @Override
    public void onGlobalLayout() {
        int halfWidth = mCoffeeIcon.getCoffeeIconWidth() / 2;
        int halfHeight = mCoffeeIcon.getCoffeeIconHeight() / 2;
        mLayout.layout(
            mLayout.getLeft() - halfWidth,
            mLayout.getTop() - halfHeight - mCoffeeIcon.getSteamHeight(),//高さは煙を考慮する
            mLayout.getRight() + halfWidth,
            mLayout.getBottom() + halfHeight + mCoffeeIcon.getSteamHeight()
        );
    }
    
}
