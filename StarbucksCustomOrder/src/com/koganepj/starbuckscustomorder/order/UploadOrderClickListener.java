package com.koganepj.starbuckscustomorder.order;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class UploadOrderClickListener implements OnClickListener {
    
    private String mOrder; 
    
    public UploadOrderClickListener(String order) {
        mOrder = order;
    }
    
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "#" + mOrder);
        v.getContext().startActivity(intent);
    }
    
//    カスタマイズ済みの投稿Viewを使う場合は以下のコメントアウトを有効化
//    private View mUploadView;
//
//    public UploadOrderClickListener(View uploadView) {
//        mUploadView = uploadView;
//    }
//
//    @Override
//    public void onClick(View v) {
//        Animation uploadViewAnimation = AnimationUtils.loadAnimation(
//                v.getContext(), R.anim.animation_upload_view);
//        mUploadView.setVisibility(View.VISIBLE);
//        mUploadView.startAnimation(uploadViewAnimation);
//        ((UploadView) mUploadView).showKeyboard();
//    }

}
