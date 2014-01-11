package com.koganepj.starbuckscustomorder.order;

import com.koganepj.starbuckscustomorder.R;

import android.app.Activity;
import android.os.Bundle;

public class OrderActivity extends Activity {
	private String mOrder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		
		// TODO デバック
		mOrder = "ダークモカフラペチーノ ほげほげ";
		
		findViewById(R.id.TextBack).setOnClickListener(new BackTextClickListener(this));
	}
	
	String getOrder() {
		return mOrder;
	}
}
