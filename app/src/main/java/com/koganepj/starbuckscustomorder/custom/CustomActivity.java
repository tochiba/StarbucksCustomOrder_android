package com.koganepj.starbuckscustomorder.custom;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.koganepj.starbuckscustomorder.admob.AdmobWrapper;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.Base;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Espresso;
import com.koganepj.starbuckscustomorder.model.Jelly;
import com.koganepj.starbuckscustomorder.model.Milk;
import com.koganepj.starbuckscustomorder.model.Powder;
import com.koganepj.starbuckscustomorder.model.Sauce;
import com.koganepj.starbuckscustomorder.model.Syrup;
import com.koganepj.starbuckscustomorder.model.WhippedCream;

public class CustomActivity extends Activity {
    
    public static final String KEY_PARAM_COFFEENAME = "key_coffeename";
    
    private CustomFragment mCustomFragment;
    private CoffeeName mCoffeeName;
	private AdmobWrapper mWrapper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        
        mCustomFragment = (CustomFragment)getFragmentManager().findFragmentById(R.id.FragmentCustom);
        mCoffeeName = (CoffeeName)getIntent().getSerializableExtra(KEY_PARAM_COFFEENAME);
        
        findViewById(R.id.TextBack).setOnClickListener(new BackTextClickListener(this));

        mWrapper = new AdmobWrapper(this); 
        ((FrameLayout) findViewById(R.id.FrameAd)).addView(mWrapper.getAdView());
		mWrapper.loadAd();
        
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("coffee_name", mCoffeeName.getCoffeeName());
        FlurryWrapper.logEvent("custom_onCreate", params);
    }
    
    CoffeeName getCoffeeName() {
        return mCoffeeName;
    }
    
    public void changeEspresso(Espresso espresso) {
        mCustomFragment.changeEspresso(espresso);//この呼び方だとFragment再生成時はカスタマイズが初期化されるが許容範囲とする
    }
    
    public void changeBase(Base base) {
        mCustomFragment.changeBase(base);
    }
    
    public void changeJelly(Jelly jelly) {
        mCustomFragment.changeJelly(jelly);
    }
    
    public void changeMilk(Milk milk) {
        mCustomFragment.changeMilk(milk);
    }
    
    public void changePowder(Powder powder) {
        mCustomFragment.changePowder(powder);
    }
    
    public void changeSauce(Sauce sauce) {
        mCustomFragment.changeSauce(sauce);
    }
    
    public void changeSyrup(Syrup syrup) {
        mCustomFragment.changeSyrup(syrup);
    }
    
    public void changeWhippedCream(WhippedCream whippedCream) {
        mCustomFragment.changeWhippedCream(whippedCream);
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
    
    @Override
    protected void onResume() {
		mWrapper.loadAd();
    	super.onResume();
    }
    
    @Override
    protected void onDestroy() {
		mWrapper.destroy();
    	super.onDestroy();
    }
    
}
