package com.koganepj.starbuckscustomorder.view.ranking.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

import com.koganepj.starbuckscustomorder.model.Photo;

class ImageLoader {
    
    private Context mContext;
    
    public ImageLoader(Context context) {
        mContext = context;
    }
    
    Bitmap getRoundedImage(Photo photo) {
        Bitmap bitmap = getReducedImage(photo);
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.BLUE);
        
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getHeight() / 2, paint);
        
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        
        canvas.drawBitmap(bitmap, rect, rect, paint);
        
        return result;
    }
    
    private Bitmap getReducedImage(Photo photo) {
        Options options = new Options();
        options.inSampleSize = 4;
        return BitmapFactory.decodeResource(mContext.getResources(), photo.getPhoto(), options);
    }
}
