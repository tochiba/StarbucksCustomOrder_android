package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;
import java.util.Locale;

import android.test.AndroidTestCase;
import android.util.Log;

import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Hotness;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
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
    
    public void test商品一覧から詳細情報を取得する() {
    	CoffeeListParser parser = new CoffeeListParser(getContext());
    	ArrayList<SimpleCoffeeModel> coffeeLists = parser.getCoffeeList();
    	
    	for (SimpleCoffeeModel model: coffeeLists) {
            CoffeeFinder finder = new CoffeeFinder(getContext(), model.coffeeName);
            Coffee coffee = finder.find();
            
			String errorMessage = String.format(Locale.getDefault(), "%s が見つかりません", model.coffeeName.getCoffeeName());
			// 値段で取得できたか確認する
			assertNotNull(errorMessage, coffee.price);
                
            //一応コーヒーの名前を出力して確認しておく
            Log.d("test", "The coffeeName is " + coffee.name);
    	}
    }
    
    public void test好みから選ばれた商品の詳細情報を取得する() {
        CoffeeNameFinder nameFinder = new CoffeeNameFinder(getContext());
        
        //甘さと温度の５段階ずつをテスト
        for (int sweetnessValue = 0; sweetnessValue < 5; sweetnessValue++) {
            for (int hotnessValue = 0; hotnessValue < 5; hotnessValue++) {
                Sweetness sweetness = new Sweetness(sweetnessValue);
                Hotness hotness = new Hotness(hotnessValue);
                
                //検査
                CoffeeName coffeeName = nameFinder.findName(sweetness, hotness);
                CoffeeFinder finder = new CoffeeFinder(getContext(), coffeeName);
                Coffee coffee = finder.find();
                
                String errorMessage = String.format(Locale.getDefault(), "%s が見つかりません", coffeeName.getCoffeeName() );
                assertNotNull(errorMessage, coffee.name.getCoffeeName());
                
                //一応コーヒーの名前を出力して確認しておく
                Log.d("test", "The coffeeName is " + coffee.name);
            }
        }
    	
    }
    
}
