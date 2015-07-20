package com.koganepj.starbuckscustomorder.setting;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.free.R;

public class SettingActivity extends Activity implements OnClickListener {
    
    private static final String BLOG_URL = "http://koganepj.hatenablog.com/";
    private static final String KOGANEPJ_MAIL = "mailto:koganepj@gmail.com?subject=【問い合わせ】スタバで呪文";
    private static final String SUPPORT_URL = "http://www1415uo.sakura.ne.jp/jumon.html";
    private static final String DEV_TEAM_URL = "http://www1415uo.sakura.ne.jp/member/a_member.html";
    
    private static SparseArray<String> sIdUrlMap = new SparseArray<String>();
    static {
        sIdUrlMap.put(R.id.TextDevTeam, DEV_TEAM_URL);
        sIdUrlMap.put(R.id.TextMail, KOGANEPJ_MAIL);
        sIdUrlMap.put(R.id.TextSupportPage, SUPPORT_URL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        
        View backText = findViewById(R.id.TextBack);
        backText.setOnClickListener(new BackTextClickListener(this));
        
        findViewById(R.id.TextDevTeam).setOnClickListener(this);
        findViewById(R.id.TextMail).setOnClickListener(this);
        findViewById(R.id.TextSupportPage).setOnClickListener(this);

        //バージョン表示
        try {
            String versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            String textAppVersion = getString(R.string.setting_version, versionName);
            ((TextView)findViewById(R.id.TextAppVersion)).setText(textAppVersion);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        String url = sIdUrlMap.get(v.getId(), BLOG_URL);
        
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("url", url);
        FlurryWrapper.logEvent("setting_tap_item", params);
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
