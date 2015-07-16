package com.koganepj.starbuckscustomorder.order;

import java.util.HashMap;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;

import net.gimite.jatts.JapaneseTextToSpeech;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class TalkOrderClickListener implements OnClickListener {
	private Activity mActivity;
	private String mOrder;

	TalkOrderClickListener(Activity activity, String order) {
		mActivity = activity;
		mOrder = order;
	}

	@Override
	public void onClick(View v) {
	    FlurryWrapper.logEvent("order_talk");
	    
		JapaneseTextToSpeech speech = new JapaneseTextToSpeech(mActivity, null);
		HashMap<String, String> params = new HashMap<String, String>();
		params.put(JapaneseTextToSpeech.KEY_PARAM_SPEAKER, "female01");
		speech.speak(mOrder, TextToSpeech.QUEUE_FLUSH, params);
		
		showDescriptionToast();
	}
	
	void showDescriptionToast() {
	    ConnectivityManager connectivityManager = (ConnectivityManager)mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
	    if (networkInfo != null && networkInfo.isConnected()) {
	        Toast.makeText(mActivity, R.string.order_will_read_jumon, Toast.LENGTH_SHORT).show();
	        return;
	    }
        Toast.makeText(mActivity, R.string.order_cant_read_jumon, Toast.LENGTH_LONG).show();
	    
	}

}
