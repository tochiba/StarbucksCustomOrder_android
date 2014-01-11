package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map.Entry;

import android.test.AndroidTestCase;
import android.util.Log;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.Price;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.model.Size;

public class PriceFinderTest extends AndroidTestCase {

	public void testカスタマイズ名から値段を取得する() {
		final PriceFinder finder = new PriceFinder(getContext());

		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(getContext());
		final NSDictionary priceDict = (NSDictionary) (rootDict
				.objectForKey("PriceDic"));
		// カスタマイズ名をループさせる
		for (Entry<String, NSObject> entry : priceDict.entrySet()) {

			// 検査
			final Price price = finder.getPrice(entry.getKey());
			String errorMessage = String.format("%s がみつかりません", entry.getKey());
			assertNotNull(errorMessage, price);

			Log.d("test", String.format("%s の値段は %s です.", entry.getKey(),
							price.getPrice()));
		}

	}
	
	public void testコーヒーのサイズに合わせて値段を返す (){
    	PriceFinder priceFinder = new PriceFinder(getContext());
    	
    	// コーヒーの一覧を取得
    	CoffeeListParser parser = new CoffeeListParser(getContext());
    	ArrayList<SimpleCoffeeModel> coffeeLists = parser.getCoffeeList();
    	
    	for (SimpleCoffeeModel model: coffeeLists) {
            CoffeeFinder coffeeFinder = new CoffeeFinder(getContext(), model.coffeeName);
            Coffee coffee = coffeeFinder.find();
            
            int count = coffee.size.size();
            
            for (int i = 0; i < count; i++) {
            	// コーヒーのサイズに合わせて値段を返す
            	Price actualPrice = priceFinder.getSizePrice(coffee, coffee.size.get(i));
            	// 実際の値段
            	int expectedPrice = coffee.price.getPrice() + (40 * i); 
            	
				String errorMessage = String.format(Locale.getDefault(),
						"%s が見つかりません", model.coffeeName.getCoffeeName());
				
				// 値段が合っているか確認する
				assertEquals(errorMessage, expectedPrice, actualPrice.getPrice());
				// 一応コーヒーの名前を出力して確認しておく
				Log.d("test", "The coffeeName is " + coffee.name);
            }
    	}
	}
}
