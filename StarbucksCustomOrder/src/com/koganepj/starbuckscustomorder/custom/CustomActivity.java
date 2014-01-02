package com.koganepj.starbuckscustomorder.custom;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.CoffeeName;

public class CustomActivity extends Activity {
    
    public static final String KEY_PARAM_COFFEENAME = "key_coffeename";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        
        //パラメータを取得してFragmentに渡す
        CoffeeName coffeeName = (CoffeeName)getIntent().getSerializableExtra(KEY_PARAM_COFFEENAME);
        Bundle bundle = new Bundle();
        bundle.putSerializable(CustomFragment.KEY_PARAM_COFFEENAME, coffeeName);
        Fragment fragment = getFragmentManager().findFragmentById(R.id.FragmentCustom);
        fragment.setArguments(bundle);
        
        findViewById(R.id.TextBack).setOnClickListener(new BackTextClickListener(this));
    }
    
}
