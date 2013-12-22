package com.koganepj.starbuckscustomorder.view.menu;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.CoffeeListModel;
import com.koganepj.starbuckscustomorder.parse.CoffeeListParser;
import com.koganepj.starbuckscustomorder.view.menu.simple.SimpleAdapter;
import com.koganepj.starbuckscustomorder.view.menu.visual.VisualAdapter;

public class MenuFragment extends Fragment {
    
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, null);

//        final ListView listView = (ListView)view.findViewById(R.id.ListMenu);
        final FrameLayout frameLayout = (FrameLayout)view.findViewById(R.id.ListFrame);
        RadioGroup modeRadioGroup = (RadioGroup)view.findViewById(R.id.RadioGroupMenuShowType);
        
        // Plistから商品一覧を取得する処理
        final CoffeeListParser coffeeListParser = new CoffeeListParser(getActivity());
        final ArrayList<CoffeeListModel> coffeeList = coffeeListParser.getCoffeeList();
        
        //モード切り替えを仮実装
        modeRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RadioSimple) {//シンプルモード
                    //ListViewの入れ替え
                    frameLayout.removeAllViews();
                    ListView listView = (ListView)inflater.inflate(R.layout.layout_menu_list_simple, null);
                    frameLayout.addView(listView);
                    
                    ArrayAdapter<String> arrayAdapter = new SimpleAdapter(getActivity());
                    for (int i = 0; i < 100; i++) {
                        arrayAdapter.add("count : " + i);
                    }
                    listView.setAdapter(arrayAdapter);
                    return;
                }
                
                if (checkedId == R.id.RadioVisual) {//ビジュアルモード
                    //ListViewの入れ替え
                    frameLayout.removeAllViews();
                    ListView listView = (ListView)inflater.inflate(R.layout.layout_menu_list_visual, null);
                    frameLayout.addView(listView);

                    //仮データを入れておく
                    ArrayAdapter<String> adapter = new VisualAdapter(getActivity());
                    listView.setAdapter(adapter);
                    for (int i = 0; i < 100; i++) {
                        adapter.add("number:" + (i + 1) + " (from visualadapter)");
                    }
                    listView.setAdapter(adapter);
                    return;
                }
            }
        });
        
        //初期表示
        modeRadioGroup.check(R.id.RadioSimple);
        
        return view;
    }
    
}
