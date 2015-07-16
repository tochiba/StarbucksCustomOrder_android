package com.koganepj.starbuckscustomorder;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.tablistener.LikeTabListener;
import com.koganepj.starbuckscustomorder.tablistener.MenuTabListener;
import com.koganepj.starbuckscustomorder.tablistener.RankingTabListener;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Crashlytics.start(this);
        setContentView(R.layout.activity_main);
        
        //アクションバーの設定
        ActionBar actionBar =  getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        
        //タブの初期設定-------------
        Tab likeTab = actionBar.newTab().setText(R.string.tab_like);
        Tab menuTab = actionBar.newTab().setText(R.string.tab_menu);
        Tab rankTab = actionBar.newTab().setText(R.string.tab_ranking);
        
        likeTab.setIcon(R.drawable.tab_icon_matrix);
        menuTab.setIcon(R.drawable.tab_icon_menu);
        rankTab.setIcon(R.drawable.tab_icon_ranking);
        
        int rootViewId = R.id.LayoutContainer;
        
        likeTab.setTabListener(new LikeTabListener(rootViewId));
        menuTab.setTabListener(new MenuTabListener(rootViewId));
        rankTab.setTabListener(new RankingTabListener(rootViewId));
        
        actionBar.addTab(likeTab);
        actionBar.addTab(menuTab);
        actionBar.addTab(rankTab);
        //--------------------------
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        FlurryWrapper.onStartSession(this);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        FlurryWrapper.onEndSession(this);
    }
    
}
