package com.koganepj.starbuckscustomorder.view.menu;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.koganepj.starbuckscustomorder.admob.AdmobWrapper;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.parse.CoffeeListParser;
import com.koganepj.starbuckscustomorder.view.menu.adapter.MenuAdapter;
import com.koganepj.starbuckscustomorder.view.menu.adapter.MenuMode;
import com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper.MenuCellModel;
import com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper.MenuCellModelListFactory;

class ModeChangeListener implements OnCheckedChangeListener {
    
    private Context mContext;
    private ViewGroup mFrameLayout;
    private LayoutInflater mInflater;
    private AdmobWrapper mHeaderAdWrapper;
    private AdmobWrapper mFooterAdWrapper;
    
    private MenuAdapter mMenuAdapter;
    
    public ModeChangeListener(Context context, ViewGroup frameLayout, AdmobWrapper headerAdWrapper, AdmobWrapper footerWraper) {
        mContext = context;
        mFrameLayout = frameLayout;
        mInflater = LayoutInflater.from(context);
        mHeaderAdWrapper = headerAdWrapper;
        mFooterAdWrapper = footerWraper;
        
        prepareAdapter();
    }
    
    void prepareAdapter() {
        mMenuAdapter = new MenuAdapter(mContext);
        CoffeeListParser coffeeListParser = new CoffeeListParser(mContext);
        ArrayList<SimpleCoffeeModel> coffeeList = coffeeListParser.getCoffeeList();
        
        MenuCellModelListFactory factory = new MenuCellModelListFactory();
        ArrayList<MenuCellModel> cellModelList = factory.create(coffeeList);;
        mMenuAdapter.addAll(cellModelList);
    }
    
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    	// 広告の更新
    	mHeaderAdWrapper.loadAd();
    	mFooterAdWrapper.loadAd();
    	
        if (checkedId == R.id.RadioSimple) {//シンプルモード
            FlurryWrapper.logEvent("menu_change_mode_to_simple");
            
            //ListViewの入れ替え
            mFrameLayout.removeAllViews();
            ListView listView = (ListView)mInflater.inflate(R.layout.layout_menu_list_simple, null);
            mFrameLayout.addView(listView);
            listView.setOnItemClickListener(new OnRowClickListener());
            
            mMenuAdapter.setModeTo(MenuMode.SIMPLE);
            listView.addHeaderView(mHeaderAdWrapper.getAdView());
            listView.addFooterView(mFooterAdWrapper.getAdView());
            listView.setAdapter(mMenuAdapter);
            
            return;
        }
        
        if (checkedId == R.id.RadioVisual) {//ビジュアルモード
            FlurryWrapper.logEvent("menu_change_mode_to_visual");
            
            //ListViewの入れ替え
            mFrameLayout.removeAllViews();
            ListView listView = (ListView)mInflater.inflate(R.layout.layout_menu_list_visual, null);
            mFrameLayout.addView(listView);
            listView.setOnItemClickListener(new OnRowClickListener());

            mMenuAdapter.setModeTo(MenuMode.VISUAL);
            listView.addHeaderView(mHeaderAdWrapper.getAdView());
            listView.addFooterView(mFooterAdWrapper.getAdView());
            listView.setAdapter(mMenuAdapter);
            return;
        }

    }

}
