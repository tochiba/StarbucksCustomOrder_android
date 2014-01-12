package com.koganepj.starbuckscustomorder.admob;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.view.View;

public class AdmobWrapper {
	private static final String PUB_ID = "a152d1d922985f8";
	
	private Activity mActivity;
	private AdView mAdView;
	
	public AdmobWrapper(Activity activity) {
		mActivity = activity;
	}
	
	public View getAdView() {
		if (!PayTypeUtil.isPayVersion(mActivity.getApplicationContext())) {
			return new View(mActivity);
		}
		if (mAdView == null) {
			mAdView = new AdView(mActivity, AdSize.BANNER, PUB_ID);
		}
		
		return mAdView;
	}
	
	public void loadAd() {
		if (mAdView == null) {
			return;
		}
		
		mAdView.loadAd(new AdRequest());
	}
	
	public void destroy() {
		if (mAdView == null) {
			return;
		}
		mAdView.destroy();
	}
}
