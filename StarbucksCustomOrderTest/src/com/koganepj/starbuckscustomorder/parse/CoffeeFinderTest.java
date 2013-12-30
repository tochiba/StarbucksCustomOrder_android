package com.koganepj.starbuckscustomorder.parse;

import java.util.Locale;

import android.test.AndroidTestCase;
import android.util.Log;

import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Hotness;
import com.koganepj.starbuckscustomorder.model.Sweetness;

public class CoffeeFinderTest extends AndroidTestCase {
    
    public void test甘さと温度にそれぞれ５段階づつの幅がある() {
        CoffeeNameFinder finder = new CoffeeNameFinder(getContext());
        
        //甘さと温度の５段階ずつをテスト
        for (int sweetnessValue = 0; sweetnessValue < 5; sweetnessValue++) {
            for (int hotnessValue = 0; hotnessValue < 5; hotnessValue++) {
                Sweetness sweetness = new Sweetness(sweetnessValue);
                Hotness hotness = new Hotness(hotnessValue);
                
                //検査
                CoffeeName coffeeName = finder.findName(sweetness, hotness);
                String errorMessage = String.format(Locale.getDefault(), "甘さ：%d、温度：%d がありません", sweetness.getLevel(), hotness.getLevel());
                assertNotNull(errorMessage, coffeeName);
                
                //一応コーヒーの名前を出力して確認しておく
                Log.d("test", "The coffeeName is " + coffeeName.getCoffeeName());
            }
        }
    }
    
}
