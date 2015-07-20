package com.koganepj.starbuckscustomorder.view.like.matrix;

import com.koganepj.starbuckscustomorder.free.R;

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
    
    private CoffeeIcon mCoffeeIcon;
    
    public CoffeeImageChanger(CoffeeIcon coffeeIcon) {
        mCoffeeIcon = coffeeIcon;
    }
    
    private int mCurrentIndex = -1;
    
    void changeImage(int backgroundWidth, int nextX) {
        int division = backgroundWidth / IMAGE_ARRAY.length;
        
        int index = nextX / division;
        if (IMAGE_ARRAY.length <= index) {
            index = IMAGE_ARRAY.length - 1;
        }
        if (mCurrentIndex == index) {
            return;
        }

        mCoffeeIcon.setCoffeeImage(IMAGE_ARRAY[index]);
        mCurrentIndex = index;
    }
    
}
