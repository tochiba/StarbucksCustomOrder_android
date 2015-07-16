package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.view.support.SelectSizeMapper;
import com.koganepj.starbuckscustomorder.model.Size;

public class SizeSelectView extends RadioGroup implements OnCheckedChangeListener {
    
    private SelectSizeMapper mSelectSizeMapper;
    private OnChangeSizeListener mListener;
    private SparseArray<Size> mIdSizeMap = new SparseArray<Size>();
    
    public SizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnCheckedChangeListener(this);
        
        mSelectSizeMapper = new SelectSizeMapper();
    }
    
    public void setSize(ArrayList<Size> sizeList) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        addView(createSpaceView());
        
        for (Size size : sizeList) {
            RadioButton radioButton = (RadioButton)inflater.inflate(R.layout.layout_custom_size_select_radio, null);
            radioButton.setId(mSelectSizeMapper.getId(size));
            radioButton.setBackgroundResource(mSelectSizeMapper.getSelector(size));
            addView(radioButton);
            addView(createSpaceView());
            
            mIdSizeMap.put(radioButton.getId(), size);
        }
        
        ((RadioButton)getChildAt(1)).setChecked(true);
    }
    
    View createSpaceView() {
        View spaceView = new View(getContext());
        spaceView.setLayoutParams(new LayoutParams(0, 0, 1F));
        return spaceView;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (mListener == null) {
            return;
        }
        mListener.changeSize(mIdSizeMap.get(checkedId));
    }
    
    public void setOnChangeSizeListener(OnChangeSizeListener listener) {
        mListener = listener;
    }
    
    public static interface OnChangeSizeListener {
        void changeSize(Size size);
    }

}
