package com.koganepj.starbuckscustomorder.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;

public class UploadView extends LinearLayout {
	private LayoutInflater mInflater;

	public UploadView(Context context, AttributeSet attrs) {
		super(context, attrs);

		mInflater = LayoutInflater.from(context);
		mInflater.inflate(R.layout.layout_order_upload, this, true);
		
		((TextView)findViewById(R.id.TextClose)).setOnClickListener(new CloseTextClickListener(this));
	}

	public void setHashTag(String hashTag) {
		((EditText) findViewById(R.id.TextMessage)).setText(String.format(" #%s", hashTag));
	}

}
