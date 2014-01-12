package com.koganepj.starbuckscustomorder.order;

import java.util.HashMap;

import net.gimite.jatts.JapaneseTextToSpeech;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;

public class TalkOrderClickListener implements OnClickListener {
	private Activity mActivity;
	private String mOrder;

	TalkOrderClickListener(Activity activity, String order) {
		mActivity = activity;
		mOrder = order;
	}

	@Override
	public void onClick(View v) {
		JapaneseTextToSpeech speech = new JapaneseTextToSpeech(mActivity, null);
		HashMap<String, String> params = new HashMap<String, String>();
		params.put(JapaneseTextToSpeech.KEY_PARAM_SPEAKER, "female01");
		speech.speak(mOrder, TextToSpeech.QUEUE_FLUSH, params);
	}

}
