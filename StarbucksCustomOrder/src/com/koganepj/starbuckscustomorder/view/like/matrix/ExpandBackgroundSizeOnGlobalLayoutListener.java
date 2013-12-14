package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import com.koganepj.starbuckscustomorder.R;

/**
 * ドラッグする画像のサイズに合わせて背景サイズの拡張を行うクラスです
 * @author shoma2da
 */
class ExpandBackgroundSizeOnGlobalLayoutListener implements OnGlobalLayoutListener {
    
    private MatrixSelectorLayout mLayout;
    
    public ExpandBackgroundSizeOnGlobalLayoutListener(MatrixSelectorLayout layout) {
        mLayout = layout;
    }
    
    @Override
    public void onGlobalLayout() {
        View dragView = mLayout.findViewById(R.id.ImageMatrixSelectorIcon);
        int halfWidth = dragView.getWidth() / 2;
        int halfHeight = dragView.getHeight() / 2;
        mLayout.setPadding(halfWidth, halfHeight, halfWidth, halfHeight);
    }
    
}
