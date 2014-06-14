package com.koganepj.starbuckscustomorder.admob;

import android.app.Activity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class AdmobWrapper {
    
	private static final String PUB_ID = "ca-app-pub-8704720300499162/2816107414";
	
	private Activity mActivity;
	private AdView mAdView;
	
	public AdmobWrapper(Activity activity) {
		mActivity = activity;
	}
	
	public View getAdView() {
		if (mAdView == null) {
			mAdView = new AdView(mActivity);
			mAdView.setAdUnitId(PUB_ID);
			mAdView.setAdSize(AdSize.BANNER);
		}
		
		return mAdView;
	}
	
	public void loadAd() {
		if (mAdView == null) {
			return;
		}
		
		mAdView.loadAd(new AdRequest.Builder().build());
	}
	
	public void destroy() {
		if (mAdView == null) {
			return;
		}
		mAdView.destroy();
	}
}
