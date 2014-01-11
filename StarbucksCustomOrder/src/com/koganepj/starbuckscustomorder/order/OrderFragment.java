package com.koganepj.starbuckscustomorder.order;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;

public class OrderFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_order, null);
		
		View seeOrder = view.findViewById(R.id.ImageSeeOrder);
		View talkOrder = view.findViewById(R.id.ImageTalkOrder);
		View uploadOrder = view.findViewById(R.id.ImageUploadOrder);
		
		seeOrder.setOnClickListener(new SeeOrderClickListener());
		talkOrder.setOnClickListener(new TalkOrderClickListener());
		
		// TODO アップロード用のアニメーションを追加する
		uploadOrder.setOnClickListener(new UploadOrderClickListener());
		
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		String order = ((OrderActivity)getActivity()).getOrder();
		
		((TextView)getView().findViewById(R.id.TextOrder)).setText(order);
	}
}
