package com.koganepj.starbuckscustomorder;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.koganepj.starbuckscustomorder.parse.PlistProvider;
import com.koganepj.starbuckscustomorder.tablistener.LikeTabListener;
import com.koganepj.starbuckscustomorder.tablistener.MenuTabListener;
import com.koganepj.starbuckscustomorder.tablistener.RankingTabListener;

public class MainActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Plistのパース処理
        PlistProvider.parse(getApplicationContext()); 
        
        //タブの初期設定-------------
        ActionBar actionBar =  getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        Tab likeTab = actionBar.newTab().setText(R.string.tab_like);
        Tab menuTab = actionBar.newTab().setText(R.string.tab_menu);
        Tab rankTab = actionBar.newTab().setText(R.string.tab_ranking);
        
        int rootViewId = R.id.LayoutContainer;
        
        likeTab.setTabListener(new LikeTabListener(actionBar, rootViewId));
        menuTab.setTabListener(new MenuTabListener(actionBar, rootViewId));
        rankTab.setTabListener(new RankingTabListener(actionBar, rootViewId));
        
        actionBar.addTab(likeTab);
        actionBar.addTab(menuTab);
        actionBar.addTab(rankTab);
        //--------------------------
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
