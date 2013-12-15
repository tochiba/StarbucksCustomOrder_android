package com.koganepj.starbuckscustomorder.view.like.matrix;

import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.koganepj.starbuckscustomorder.R;

/**
 * コーピーカップの画像を切替えます
 * @author shoma2da
 */
class CoffeeImageChanger {
    
    public static final Integer[] IMAGE_ARRAY = new Integer[] {
        R.drawable.matrix_selector_icon_1,
        R.drawable.matrix_selector_icon_2,
        R.drawable.matrix_selector_icon_3,
        R.drawable.matrix_selector_icon_4,
        R.drawable.matrix_selector_icon_5,
        R.drawable.matrix_selector_icon_6,
        R.drawable.matrix_selector_icon_7
    };
    
    private ImageView mImageView;
    
    public CoffeeImageChanger(ImageView imageView) {
        mImageView = imageView;
    }
    
    private int mCurrentIndex = -1;
    
    void changeImage(int backgroundLeft, int backgroundRight, int nextCenterX) {
        int width = backgroundRight - backgroundLeft;
        int division = width / IMAGE_ARRAY.length;
        int fixedNextCenterX = nextCenterX - backgroundLeft;
        
        int index = fixedNextCenterX / division;
        if (IMAGE_ARRAY.length <= index) {
            index = IMAGE_ARRAY.length - 1;
        }
        if (mCurrentIndex == index) {
            return;
        }

        mImageView.setImageResource(IMAGE_ARRAY[index]);
        mCurrentIndex = index;
    }
    
}
