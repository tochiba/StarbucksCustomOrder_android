package com.koganepj.starbuckscustomorder;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.koganepj.starbuckscustomorder.setting.SettingActivity;
import com.koganepj.starbuckscustomorder.tablistener.LikeTabListener;
import com.koganepj.starbuckscustomorder.tablistener.MenuTabListener;
import com.koganepj.starbuckscustomorder.tablistener.RankingTabListener;

public class MainActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //アクションバーの設定
        ActionBar actionBar =  getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        //タブの初期設定-------------
        Tab likeTab = actionBar.newTab().setText(R.string.tab_like);
        Tab menuTab = actionBar.newTab().setText(R.string.tab_menu);
        Tab rankTab = actionBar.newTab().setText(R.string.tab_ranking);
        
        likeTab.setIcon(R.drawable.tab_icon_matrix);
        menuTab.setIcon(R.drawable.tab_icon_menu);
        rankTab.setIcon(R.drawable.tab_icon_ranking);
        
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
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_setting) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }
        return super.onMenuItemSelected(featureId, item);
    }
}
