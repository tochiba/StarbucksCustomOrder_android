package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnMatrixTouchListener implements OnTouchListener {

    private View mIconView;
    private CoffeeImageChanger mChanger;
    
    //背景のマトリックス画像の位置を保持
    private int mMatrixLeft = -1;
    private int mMatrixRight = -1;
    private int mMatrixTop = -1;
    private int mMatrixBottom = -1;
    
    public OnMatrixTouchListener(View backgroundView, CoffeeImageChanger changer) {
        mIconView = backgroundView;
        mChanger = changer;
    }

    @Override
    public boolean onTouch(View matrix, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && mMatrixLeft == -1/*チェックを簡略化*/) {
            mMatrixLeft = matrix.getLeft();
            mMatrixRight = matrix.getRight();
            mMatrixTop = matrix.getTop();
            mMatrixBottom = matrix.getBottom();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_UP) {
            //ドラッグ移動分を取得
            int x = (int)event.getX();
            int y = (int)event.getY();
            
            //左右にはみ出ないようにする
            if (x <= 0) {
                x = 0;
            } else if (matrix.getWidth() <= x) {
                x = matrix.getWidth();
            }
            
            //上下にはみ出ないようにする
            if (y <= 0) {
                y = 0;
            } else if (matrix.getHeight() <= y) {
                y = matrix.getHeight();
            }
            
            mIconView.setX(x);
            mIconView.setY(y);

            //画像を変更する
            mChanger.changeImage(matrix.getWidth() ,x);
            
//            //ドラッグ後の座標を計算
//            int nextLeft = (currentLeft + x) - (mIconView.getWidth() / 2);
//            int nextTop = (currentTop + y) - (mIconView.getHeight() / 2);
//            int nextRight = nextLeft + mIconView.getWidth();
//            int nextBottom = nextTop + mIconView.getHeight();
//            
//            //中心位置を計算
//            int nextCenterX = nextLeft + ((nextRight - nextLeft) / 2);
//            int nextCenterY = nextTop + ((nextBottom - nextTop) / 2);
//            
//            //左端に出ないようにする
//            if (nextCenterX <= mMatrixLeft) {
//                nextLeft = mMatrixLeft - (mIconView.getWidth() / 2);
//                nextRight = mMatrixLeft + (mIconView.getWidth() / 2);
//            }
//            
//            //上端に出ないようにする
//            if (nextCenterY <= mMatrixTop) {
//                nextTop = mMatrixTop - (mIconView.getHeight() / 2);
//                nextBottom = mMatrixTop + (mIconView.getHeight() / 2);
//            }
//            
//            //右端に出ないようにする
//            if (mMatrixRight <= nextCenterX) {
//                nextRight = mMatrixRight + (mIconView.getWidth() / 2);
//                nextLeft = mMatrixRight - (mIconView.getWidth() / 2);
//            }
//            
//            //下端に出ないようにする
//            if (mMatrixBottom <= nextCenterY) {
//                nextBottom = mMatrixBottom + (mIconView.getHeight() / 2);
//                nextTop = mMatrixBottom - (mIconView.getHeight() / 2);
//            }
//            
//            //再度中心位置を計算
//            nextCenterX = nextLeft + ((nextRight - nextLeft) / 2);
//            nextCenterY = nextTop + ((nextBottom - nextTop) / 2);
//            
//            //画像を変更する
//            mChanger.changeImage(mMatrixLeft, mMatrixRight, nextCenterX);
//            
//            Log.d("test", "next left is : " + nextLeft);
//            Log.d("test", "\t\t\tnext top is : " + nextTop);
//            //画像を移動する
//            mIconView.setX(nextLeft);
//            mIconView.setY(nextTop);
        }
        return true;
    }

}
