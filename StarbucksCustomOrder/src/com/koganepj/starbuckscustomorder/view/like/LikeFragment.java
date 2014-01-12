package com.koganepj.starbuckscustomorder.view.like;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.admob.AdmobWrapper;
import com.koganepj.starbuckscustomorder.parse.CoffeeNameFinder;
import com.koganepj.starbuckscustomorder.view.like.matrix.MatrixSelectorLayout;

public class LikeFragment extends Fragment {
	private AdmobWrapper mWrapper;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, null);
        
        View settingIcon = view.findViewById(R.id.ImageSettingIcon);
        settingIcon.setOnClickListener(new SettingIconClickListener(getActivity()));
        
        MatrixSelectorLayout matrixSelectorLayout = (MatrixSelectorLayout)view.findViewById(R.id.LayoutMatrix);
        CoffeeNameFinder finder = new CoffeeNameFinder(getActivity());
        
        View okButton = view.findViewById(R.id.ButtonOk);
        okButton.setOnClickListener(new OnDecideButtonClickListener(matrixSelectorLayout, finder));
        
        // 広告
        mWrapper = new AdmobWrapper(getActivity()); 
        ((FrameLayout) view.findViewById(R.id.FrameAd)).addView(mWrapper.getAdView());
        
        return view;
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	
        mWrapper.loadAd();
    }
    
    @Override
    public void onDestroy() {
    	mWrapper.destroy();
    	super.onDestroy();
    }
}
