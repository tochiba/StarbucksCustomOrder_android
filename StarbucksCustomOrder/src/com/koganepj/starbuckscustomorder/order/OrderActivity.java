package com.koganepj.starbuckscustomorder.order;

import android.app.Activity;
import android.os.Bundle;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Photo;

public class OrderActivity extends Activity {
    
    public static final String KEY_JUMON = "key_jumon";
    public static final String KEY_PHOTO = "key_photo";
    
	private String mOrder;
	private Photo mPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		
		// TODO デバック
		mOrder = getIntent().getStringExtra(KEY_JUMON);
		mPhoto = (Photo)getIntent().getSerializableExtra(KEY_PHOTO);
		
		findViewById(R.id.TextBack).setOnClickListener(new BackTextClickListener(this));
	}
	
	String getOrder() {
		return mOrder;
	}
	
	Photo getPhoto() {
	    return mPhoto;
	}
}
