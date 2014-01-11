package com.koganepj.starbuckscustomorder.order;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.order.view.UploadView;

public class OrderFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_order, null);
		
		View seeOrder = view.findViewById(R.id.ImageSeeOrder);
		View talkOrder = view.findViewById(R.id.ImageTalkOrder);
		View uploadOrder = view.findViewById(R.id.ImageUploadOrder);
		View uploadOrderView = view.findViewById(R.id.LayoutUploadOrder);
		
		seeOrder.setOnClickListener(new SeeOrderClickListener());
		talkOrder.setOnClickListener(new TalkOrderClickListener());
		
		uploadOrder.setOnClickListener(new UploadOrderClickListener(uploadOrderView));
		
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		String order = ((OrderActivity)getActivity()).getOrder();
		((TextView)getView().findViewById(R.id.TextOrder)).setText(order);
		((UploadView)getView().findViewById(R.id.LayoutUploadOrder)).setHashTag(order.replaceAll(" ", ""));
	}
}
