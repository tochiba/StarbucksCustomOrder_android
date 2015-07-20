package com.koganepj.starbuckscustomorder.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.free.R;

public class UploadView extends LinearLayout {
	private LayoutInflater mInflater;
	private InputMethodManager mInputManager;
	private EditText mTextMessage;

	public UploadView(Context context, AttributeSet attrs) {
		super(context, attrs);

		mInflater = LayoutInflater.from(context);
		mInflater.inflate(R.layout.layout_order_upload, this, true);
		mInputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		
		mTextMessage = (EditText) findViewById(R.id.TextMessage);
		
		((TextView)findViewById(R.id.TextClose)).setOnClickListener(new CloseTextClickListener(this));
	}

	public void setHashTag(String hashTag) {
		mTextMessage.setText(String.format(" #%s", hashTag));
	}
	
	public void showKeyboard() {
		mInputManager.showSoftInput(mTextMessage, 0);
	}
	
	void hideKeyboard() {
		mInputManager.hideSoftInputFromWindow(mTextMessage.getWindowToken(), 0);
	}
}
