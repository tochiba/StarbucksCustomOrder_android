package com.koganepj.starbuckscustomorder.view.like.matrix;

import com.koganepj.starbuckscustomorder.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class MatrixSelectorLayout extends LinearLayout {

    public MatrixSelectorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_matrix_selector, this, true);
    }

}
