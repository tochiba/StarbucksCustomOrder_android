package com.koganepj.starbuckscustomorder.order.view;

import android.view.View;
import android.view.View.OnClickListener;

public class CloseTextClickListener implements OnClickListener {
	private View mView;
	
	CloseTextClickListener(View view) {
		mView = view;
	}

	@Override
	public void onClick(View v) {
		((UploadView) mView).hideKeyboard();
		mView.setVisibility(View.GONE);
	}

}
