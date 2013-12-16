package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnMatrixIconTouchListener implements OnTouchListener {

    private View mBackgroundView;
    private CoffeeImageChanger mChanger;
    
    //背景のマトリックス画像の位置を保持
    private int mMatrixLeft = -1;
    private int mMatrixRight = -1;
    private int mMatrixTop = -1;
    private int mMatrixBottom = -1;
    
    public OnMatrixIconTouchListener(View backgroundView, CoffeeImageChanger changer) {
        mBackgroundView = backgroundView;
        mChanger = changer;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && mMatrixLeft == -1/*チェックを簡略化*/) {
            mMatrixLeft = mBackgroundView.getLeft();
            mMatrixRight = mBackgroundView.getRight();
            mMatrixTop = mBackgroundView.getTop();
            mMatrixBottom = mBackgroundView.getBottom();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            //現在の座標を取得
            int currentLeft = (int)view.getX();
            int currentTop = (int)view.getY();
            
            //ドラッグ移動分を取得
            int x = (int)event.getX();
            int y = (int)event.getY();
            
            //ドラッグ後の座標を計算
            int nextLeft = (currentLeft + x) - (view.getWidth() / 2);
            int nextTop = (currentTop + y) - (view.getHeight() / 2);
            int nextRight = nextLeft + view.getWidth();
            int nextBottom = nextTop + view.getHeight();
            
            //中心位置を計算
            int nextCenterX = nextLeft + ((nextRight - nextLeft) / 2);
            int nextCenterY = nextTop + ((nextBottom - nextTop) / 2);
            
            //左端に出ないようにする
            if (nextCenterX <= mMatrixLeft) {
                nextLeft = mMatrixLeft - (view.getWidth() / 2);
                nextRight = mMatrixLeft + (view.getWidth() / 2);
            }
            
            //上端に出ないようにする
            if (nextCenterY <= mMatrixTop) {
                nextTop = mMatrixTop - (view.getHeight() / 2);
                nextBottom = mMatrixTop + (view.getHeight() / 2);
            }
            
            //右端に出ないようにする
            if (mMatrixRight <= nextCenterX) {
                nextRight = mMatrixRight + (view.getWidth() / 2);
                nextLeft = mMatrixRight - (view.getWidth() / 2);
            }
            
            //下端に出ないようにする
            if (mMatrixBottom <= nextCenterY) {
                nextBottom = mMatrixBottom + (view.getHeight() / 2);
                nextTop = mMatrixBottom - (view.getHeight() / 2);
            }
            
            //再度中心位置を計算
            nextCenterX = nextLeft + ((nextRight - nextLeft) / 2);
            nextCenterY = nextTop + ((nextBottom - nextTop) / 2);
            
            //画像を変更する
            mChanger.changeImage(mMatrixLeft, mMatrixRight, nextCenterX);
            
            //画像を移動する
            view.setX(nextLeft);
            view.setY(nextTop);
        }
        return true;
    }

}
