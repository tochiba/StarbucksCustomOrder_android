package com.koganepj.starbuckscustomorder.order;

import com.koganepj.starbuckscustomorder.R;

import android.app.Activity;
import android.os.Bundle;

public class OrderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		
		findViewById(R.id.TextBack).setOnClickListener(null);
	}
}
