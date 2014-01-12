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
	private String mOrder;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_order, null);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		mOrder = ((OrderActivity) getActivity()).getOrder();
		
		View seeOrder = getView().findViewById(R.id.ImageSeeOrder);
		View talkOrder = getView().findViewById(R.id.ImageTalkOrder);
		View uploadOrder = getView().findViewById(R.id.ImageUploadOrder);
		View uploadOrderView = getView().findViewById(R.id.LayoutUploadOrder);

		seeOrder.setOnClickListener(new SeeOrderClickListener());
		talkOrder.setOnClickListener(new TalkOrderClickListener(getActivity(), mOrder));

		uploadOrder.setOnClickListener(new UploadOrderClickListener(
				uploadOrderView));
	}

	@Override
	public void onResume() {
		super.onResume();

		((TextView) getView().findViewById(R.id.TextOrder)).setText(mOrder);
		((UploadView) getView().findViewById(R.id.LayoutUploadOrder))
				.setHashTag(mOrder.replaceAll(" ", ""));
	}
}
