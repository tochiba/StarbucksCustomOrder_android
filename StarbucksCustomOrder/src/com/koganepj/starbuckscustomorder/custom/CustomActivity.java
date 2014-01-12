package com.koganepj.starbuckscustomorder.custom;

import android.app.Activity;
import android.os.Bundle;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.flurry.FlurryWrapper;
import com.koganepj.starbuckscustomorder.model.Base;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Espresso;
import com.koganepj.starbuckscustomorder.model.Jelly;
import com.koganepj.starbuckscustomorder.model.Milk;

public class CustomActivity extends Activity {
    
    public static final String KEY_PARAM_COFFEENAME = "key_coffeename";
    
    private CustomFragment mCustomFragment;
    private CoffeeName mCoffeeName;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        
        mCustomFragment = (CustomFragment)getFragmentManager().findFragmentById(R.id.FragmentCustom);
        mCoffeeName = (CoffeeName)getIntent().getSerializableExtra(KEY_PARAM_COFFEENAME);
        
        findViewById(R.id.TextBack).setOnClickListener(new BackTextClickListener(this));
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
