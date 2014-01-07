package com.koganepj.starbuckscustomorder.custom;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.CoffeeName;

public class CustomActivity extends Activity {
    
    public static final String KEY_PARAM_COFFEENAME = "key_coffeename";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        
        //パラメータを取得
        CoffeeName coffeeName = (CoffeeName)getIntent().getSerializableExtra(KEY_PARAM_COFFEENAME);
        Log.d("test", "The coffee name is " + coffeeName.getCoffeeName());
        
        findViewById(R.id.TextBack).setOnClickListener(new BackTextClickListener(this));
    }
    
}
