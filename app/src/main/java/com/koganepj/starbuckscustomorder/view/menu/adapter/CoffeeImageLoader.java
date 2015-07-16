package com.koganepj.starbuckscustomorder.view.menu.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

class CoffeeImageLoader {
    
    private Resources mResources;
    
    CoffeeImageLoader(Resources resources) {
        mResources = resources;
    }
    
    Bitmap loadImage(int resId, MenuMode menuMode) {
        if (menuMode == MenuMode.VISUAL) {
            return BitmapFactory.decodeResource(mResources, resId);
        }
        
        //シンプルモードの場合は1/4に縮小して読み込む
        Options options = new Options();
        options.inSampleSize = 4;
        return BitmapFactory.decodeResource(mResources, resId, options);
    }
    
}
