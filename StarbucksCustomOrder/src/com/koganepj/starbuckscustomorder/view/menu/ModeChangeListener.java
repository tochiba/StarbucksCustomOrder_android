package com.koganepj.starbuckscustomorder.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.view.menu.simple.SimpleAdapter;
import com.koganepj.starbuckscustomorder.view.menu.visual.VisualAdapter;

class ModeChangeListener implements OnCheckedChangeListener {
    
    private Context mContext;
    private ViewGroup mFrameLayout;
    private LayoutInflater mInflater;
    
    public ModeChangeListener(Context context, ViewGroup frameLayout) {
        mContext = context;
        mFrameLayout = frameLayout;
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.RadioSimple) {//シンプルモード
            //ListViewの入れ替え
            mFrameLayout.removeAllViews();
            ListView listView = (ListView)mInflater.inflate(R.layout.layout_menu_list_simple, null);
            mFrameLayout.addView(listView);
            
            ArrayAdapter<String> arrayAdapter = new SimpleAdapter(mContext);
            for (int i = 0; i < 100; i++) {
                arrayAdapter.add("count : " + i);
            }
            listView.setAdapter(arrayAdapter);
            return;
        }
        
        if (checkedId == R.id.RadioVisual) {//ビジュアルモード
            //ListViewの入れ替え
            mFrameLayout.removeAllViews();
            ListView listView = (ListView)mInflater.inflate(R.layout.layout_menu_list_visual, null);
            mFrameLayout.addView(listView);

            //仮データを入れておく
            ArrayAdapter<String> adapter = new VisualAdapter(mContext);
            listView.setAdapter(adapter);
            for (int i = 0; i < 100; i++) {
                adapter.add("number:" + (i + 1) + " (from visualadapter)");
            }
            listView.setAdapter(adapter);
            return;
        }

    }

}
