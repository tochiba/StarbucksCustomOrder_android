package com.koganepj.starbuckscustomorder.setting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;

import com.koganepj.starbuckscustomorder.R;

public class SettingActivity extends Activity implements OnClickListener {
    
    private static final String BLOG_URL = "http://koganepj.hatenablog.com/";
    private static final String KOGANEPJ_MAIL = "mailto:koganepj@gmail.com?subject=【問い合わせ】スタバで呪文";
    private static final String SUPPORT_URL = "http://www1415uo.sakura.ne.jp/jumon.html";
    private static final String DEV_TEAM_URL = "http://www1415uo.sakura.ne.jp/member/index.html";
    private static final String HISTORY_URL = "http://koganepj.hatenablog.com/entry/2013/11/09/010910";
    
    private static SparseArray<String> sIdUrlMap = new SparseArray<String>();
    static {
        sIdUrlMap.put(R.id.TextDevTeam, DEV_TEAM_URL);
        sIdUrlMap.put(R.id.TextHistory, HISTORY_URL);
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
        findViewById(R.id.TextHistory).setOnClickListener(this);
        findViewById(R.id.TextMail).setOnClickListener(this);
        findViewById(R.id.TextSupportPage).setOnClickListener(this);
        findViewById(R.id.TextSupportPage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse(sIdUrlMap.get(v.getId(), BLOG_URL));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
