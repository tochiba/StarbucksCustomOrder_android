package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Switch;

public class TempuretureSelectView extends Switch {
    
    public TempuretureSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setTempureture(ArrayList<String> tempuretures) {
        Log.d("test", "tempureture : " + tempuretures);
    }
    
}
