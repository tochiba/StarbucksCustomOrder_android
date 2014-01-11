package com.koganepj.starbuckscustomorder.order;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.koganepj.starbuckscustomorder.R;

public class UploadOrderClickListener implements OnClickListener {
	private View mUploadView;

	public UploadOrderClickListener(View uploadView) {
		mUploadView = uploadView;
	}

	@Override
	public void onClick(View v) {
		Animation uploadViewAnimation = AnimationUtils.loadAnimation(
				v.getContext(), R.anim.animation_upload_view);
		mUploadView.setVisibility(View.VISIBLE);
		mUploadView.startAnimation(uploadViewAnimation);
	}

}
