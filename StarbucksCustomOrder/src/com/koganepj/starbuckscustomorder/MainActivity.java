package com.koganepj.starbuckscustomorder;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //タブの初期設定
        ActionBar actionBar =  getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        Tab likeTab = actionBar.newTab().setText(R.string.tab_like);
        Tab menuTab = actionBar.newTab().setText(R.string.tab_menu);
        Tab rankTab = actionBar.newTab().setText(R.string.tab_ranking);
        
        //↓temp
        TabListener emptyListener = new TabListener() {
            @Override
            public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            }
            @Override
            public void onTabSelected(Tab tab, FragmentTransaction ft) {
            }
            @Override
            public void onTabReselected(Tab tab, FragmentTransaction ft) {
            }
        };
        likeTab.setTabListener(emptyListener);
        menuTab.setTabListener(emptyListener);
        rankTab.setTabListener(emptyListener);
        //↑temp
        
        actionBar.addTab(likeTab);
        actionBar.addTab(menuTab);
        actionBar.addTab(rankTab);
    }
}
