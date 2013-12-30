package com.koganepj.starbuckscustomorder.view.like;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.CustomActivity;

public class LikeFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, null);
        
        View settingIcon = view.findViewById(R.id.ImageSettingIcon);
        settingIcon.setOnClickListener(new SettingIconClickListener(getActivity()));
        
        View okButton = view.findViewById(R.id.ButtonOk);
        okButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //仮遷移
                Intent intent = new Intent(getActivity(), CustomActivity.class);
                getActivity().startActivity(intent);
            }
        });
        
        return view;
    }
    
}
