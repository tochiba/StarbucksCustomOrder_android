package com.koganepj.starbuckscustomorder.order;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.admob.AdmobWrapper;
import com.koganepj.starbuckscustomorder.model.Photo;

public class OrderActivity extends Activity {
    
    public static final String KEY_JUMON = "key_jumon";
    public static final String KEY_PHOTO = "key_photo";
    
	private String mOrder;
	private Photo mPhoto;
	private AdmobWrapper mWrapper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		
		mOrder = getIntent().getStringExtra(KEY_JUMON);
		mPhoto = (Photo)getIntent().getSerializableExtra(KEY_PHOTO);
		
		findViewById(R.id.TextBack).setOnClickListener(new BackTextClickListener(this));

        mWrapper = new AdmobWrapper(this); 
        ((FrameLayout) findViewById(R.id.FrameAd)).addView(mWrapper.getAdView());
		mWrapper.loadAd();
	}
	
	String getOrder() {
		return mOrder;
	}
	
	Photo getPhoto() {
	    return mPhoto;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	protected void onResume() {
		mWrapper.loadAd();
		super.onResume();
	}
	
	@Override
	protected void onDestroy() {
		mWrapper.destroy();
		super.onDestroy();
	}
}
