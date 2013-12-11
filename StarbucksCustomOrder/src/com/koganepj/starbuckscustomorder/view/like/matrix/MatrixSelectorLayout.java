package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.koganepj.starbuckscustomorder.R;

public class MatrixSelectorLayout extends FrameLayout {

    public MatrixSelectorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_selector, this, true);
        
        final View backgroundView = findViewById(R.id.ImageMatrixSelectorBackground);
        
        View iconView = findViewById(R.id.ImageMatrixSelectorIcon);
        iconView.setOnTouchListener(new OnTouchListener() {
            
            private int mMatrixWidth;
            private int mMatrixHeight;
            
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mMatrixHeight = backgroundView.getHeight();
                    mMatrixWidth = backgroundView.getWidth();
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
        });
    }

}
