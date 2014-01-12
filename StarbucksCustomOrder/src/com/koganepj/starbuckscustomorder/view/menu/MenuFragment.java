package com.koganepj.starbuckscustomorder.view.menu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.admob.AdmobWrapper;

public class MenuFragment extends Fragment {
	AdmobWrapper mHeaderAdWrapper;
	AdmobWrapper mFooterAdWrapper;
    
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, null);

        FrameLayout frameLayout = (FrameLayout)view.findViewById(R.id.ListFrame);
        RadioGroup modeRadioGroup = (RadioGroup)view.findViewById(R.id.RadioGroupMenuShowType);
        
        //広告
        mHeaderAdWrapper = new AdmobWrapper(getActivity());
        mFooterAdWrapper = new AdmobWrapper(getActivity());
        
        modeRadioGroup.setOnCheckedChangeListener(new ModeChangeListener(getActivity(), frameLayout, mHeaderAdWrapper, mFooterAdWrapper));
        
        //初期表示
        modeRadioGroup.check(R.id.RadioSimple);
        
        return view;
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	
    	mHeaderAdWrapper.loadAd();
    	mFooterAdWrapper.loadAd();
    }
    
    @Override
    public void onDestroy() {
    	mHeaderAdWrapper.destroy();
    	mFooterAdWrapper.destroy();
    	super.onDestroy();
    }
    
}
