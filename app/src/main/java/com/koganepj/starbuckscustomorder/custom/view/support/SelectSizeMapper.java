package com.koganepj.starbuckscustomorder.custom.view.support;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Size;

public class SelectSizeMapper {
    
    public static final int ID_SHORT = 1;
    public static final int ID_TALL = 2;
    public static final int ID_GRANDE = 3;
    public static final int ID_VENTI = 4;
    public static final int ID_ONESIZE = 5;
    
    public int getId(Size size) {
        String sizeStr = size.getSize();
        if ("Short".equalsIgnoreCase(sizeStr)) {
            return ID_SHORT;
        } else if ("Tall".equalsIgnoreCase(sizeStr)) {
            return ID_TALL;
        } else if ("Grande".equalsIgnoreCase(sizeStr)) {
            return ID_GRANDE;
        } else if ("Venti".equalsIgnoreCase(sizeStr)) {
            return ID_VENTI;
        } else if ("ワンサイズ".equalsIgnoreCase(sizeStr)) {
            return ID_ONESIZE;
        }
        throw new IllegalArgumentException("想定外のサイズです");
    }
    
    public int getSelector(Size size) {
        String sizeStr = size.getSize();
        if ("Short".equalsIgnoreCase(sizeStr)) {
            return R.drawable.selector_custom_size_select_short;
        } else if ("Tall".equalsIgnoreCase(sizeStr)) {
            return R.drawable.selector_custom_size_select_tall;
        } else if ("Grande".equalsIgnoreCase(sizeStr)) {
            return R.drawable.selector_custom_size_select_grande;
        } else if ("Venti".equalsIgnoreCase(sizeStr)) {
            return R.drawable.selector_custom_size_select_venti;
        } else if ("ワンサイズ".equalsIgnoreCase(sizeStr)) {
            return R.drawable.selector_custom_size_select_onesize;
        }
        throw new IllegalArgumentException("想定外のサイズです");
    }
    
}
