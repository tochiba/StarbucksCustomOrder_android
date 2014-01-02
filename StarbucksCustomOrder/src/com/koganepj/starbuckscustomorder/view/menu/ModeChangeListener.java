package com.koganepj.starbuckscustomorder.view.menu;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.koganepj.starbuckscustomorder.R;
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
    
    private MenuAdapter mMenuAdapter;
    
    public ModeChangeListener(Context context, ViewGroup frameLayout) {
        mContext = context;
        mFrameLayout = frameLayout;
        mInflater = LayoutInflater.from(context);
        
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
        if (checkedId == R.id.RadioSimple) {//シンプルモード
            //ListViewの入れ替え
            mFrameLayout.removeAllViews();
            ListView listView = (ListView)mInflater.inflate(R.layout.layout_menu_list_simple, null);
            mFrameLayout.addView(listView);
            listView.setOnItemClickListener(new OnRowClickListener());
            
            mMenuAdapter.setModeTo(MenuMode.SIMPLE);
            listView.setAdapter(mMenuAdapter);
            return;
        }
        
        if (checkedId == R.id.RadioVisual) {//ビジュアルモード
            //ListViewの入れ替え
            mFrameLayout.removeAllViews();
            ListView listView = (ListView)mInflater.inflate(R.layout.layout_menu_list_visual, null);
            mFrameLayout.addView(listView);
            listView.setOnItemClickListener(new OnRowClickListener());

            mMenuAdapter.setModeTo(MenuMode.VISUAL);
            listView.setAdapter(mMenuAdapter);
            return;
        }

    }

}
