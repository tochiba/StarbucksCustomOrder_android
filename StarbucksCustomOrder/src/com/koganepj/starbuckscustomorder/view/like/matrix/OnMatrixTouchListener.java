package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnMatrixTouchListener implements OnTouchListener {

    private View mIconView;
    private CoffeeImageChanger mChanger;
    
    //背景のマトリックス画像の大きさを保存
    private int mMatrixWidth = -1;
    private int mMatrixHeight = -1;
    
    public OnMatrixTouchListener(View backgroundView, CoffeeImageChanger changer) {
        mIconView = backgroundView;
        mChanger = changer;
    }

    @Override
    public boolean onTouch(View matrix, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && mMatrixWidth == -1/*チェックを簡略化*/) {
            mMatrixWidth = matrix.getWidth();
            mMatrixHeight = matrix.getHeight();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_UP) {
            //ドラッグ移動分を取得
            int x = (int)event.getX();
            int y = (int)event.getY();
            
            //左右にはみ出ないようにする
            if (x <= 0) {
                x = 0;
            } else if (mMatrixWidth <= x) {
                x = matrix.getWidth();
            }
            
            //上下にはみ出ないようにする
            if (y <= 0) {
                y = 0;
            } else if (mMatrixHeight <= y) {
                y = matrix.getHeight();
            }
            
            mIconView.setX(x);
            mIconView.setY(y);

            //画像を変更する
            mChanger.changeImage(mMatrixWidth, x);
        }
        return true;
    }

}
