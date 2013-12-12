package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnMatrixIconTouchListener implements OnTouchListener {

    private View mBackgroundView;
    private int mMatrixWidth = -1;
    private int mMatrixHeight = -1;
    
    public OnMatrixIconTouchListener(View backgroundView) {
        mBackgroundView = backgroundView;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && (mMatrixHeight == -1 || mMatrixWidth == -1)) {
            mMatrixHeight = mBackgroundView.getHeight();
            mMatrixWidth = mBackgroundView.getWidth();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            //現在の座標を取得
            int currentLeft = view.getLeft();
            int currentTop = view.getTop();
            
            //ドラッグ移動分を取得
            int x = (int)event.getX();
            int y = (int)event.getY();
            
            //ドラッグ後の座標を計算
            int nextLeft = (currentLeft + x) - (view.getWidth() / 2);
            int nextTop = (currentTop + y) - (view.getHeight() / 2);
            int nextRight = nextLeft + view.getWidth();
            int nextBottom = nextTop + view.getHeight();
            
            //左端に出ないようにする
            if (nextLeft <= 0) {
                nextLeft = 0;
                nextRight = view.getWidth();
            }
            
            //上端に出ないようにする
            if (nextTop <= 0) {
                nextTop = 0;
                nextBottom = view.getHeight();
            }
            
            //右端に出ないようにする
            if (mMatrixWidth <= nextRight) {
                nextRight = mMatrixWidth;
                nextLeft = mMatrixWidth - view.getWidth();
            }
            
            //下端に出ないようにする
            if (mMatrixHeight <= nextBottom) {
                nextBottom = mMatrixHeight;
                nextTop = mMatrixHeight - view.getHeight();
            }
            
            //画像を移動する
            view.layout(nextLeft, nextTop, nextRight, nextBottom);
        }
        return true;
    }

}
