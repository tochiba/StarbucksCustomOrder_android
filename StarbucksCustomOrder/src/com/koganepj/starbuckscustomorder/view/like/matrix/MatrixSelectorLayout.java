package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.koganepj.starbuckscustomorder.R;

public class MatrixSelectorLayout extends FrameLayout {

    public MatrixSelectorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_selector, this, true);
    }

}
