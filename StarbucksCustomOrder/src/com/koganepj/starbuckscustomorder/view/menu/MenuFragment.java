package com.koganepj.starbuckscustomorder.view.menu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.view.menu.simple.SimpleAdapter;
import com.koganepj.starbuckscustomorder.view.menu.visual.VisualAdapter;

public class MenuFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, null);

        final ListView listView = (ListView)view.findViewById(R.id.ListMenu);
        RadioGroup modeRadioGroup = (RadioGroup)view.findViewById(R.id.RadioGroupMenuShowType);
        
        //モード切り替えを仮実装
        modeRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RadioSimple) {
                    ArrayAdapter<String> arrayAdapter = new SimpleAdapter(getActivity());
                    for (int i = 0; i < 100; i++) {
                        arrayAdapter.add("count : " + i);
                    }
                    listView.setAdapter(arrayAdapter);
                    return;
                }
                
                if (checkedId == R.id.RadioVisual) {
                    //仮データを入れておく
                    ArrayAdapter<String> adapter = new VisualAdapter(getActivity());
                    listView.setAdapter(adapter);
                    for (int i = 0; i < 100; i++) {
                        adapter.add("number:" + (i + 1) + " (from visualadapter)");
                    }
                    listView.setAdapter(adapter);
                }
            }
        });
        
        //初期表示
        modeRadioGroup.check(R.id.RadioSimple);
        
        return view;
    }
    
}
