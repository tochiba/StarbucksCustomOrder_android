package com.koganepj.starbuckscustomorder.custom;

import com.koganepj.starbuckscustomorder.order.OrderActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MagicClickListener implements OnClickListener {

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(v.getContext(), OrderActivity.class);
		v.getContext().startActivity(intent);
	}

}
