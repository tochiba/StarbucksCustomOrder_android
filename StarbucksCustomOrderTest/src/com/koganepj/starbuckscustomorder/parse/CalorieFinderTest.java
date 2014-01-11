package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map.Entry;

import android.test.AndroidTestCase;
import android.util.Log;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Calorie;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

public class CalorieFinderTest extends AndroidTestCase {

	public void testカスタマイズ名からカロリーを取得する() {
		final CalorieFinder finder = new CalorieFinder(getContext());

		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(getContext());
		final NSDictionary calorieDict = (NSDictionary) (rootDict
				.objectForKey("CalorieDic"));
		// カスタマイズ名をループさせる
		for (Entry<String, NSObject> entry : calorieDict.entrySet()) {

			// 検査
			final Calorie calorie = finder.getCalorie(entry.getKey());
			String errorMessage = String.format("%s がみつかりません", entry.getKey());
			assertNotNull(errorMessage, calorie);

			Log.d("test", String.format("%s のカロリーは %s です.", entry.getKey(),
							calorie.getCalorie()));
		}
	}
	
	public void testコーヒーのサイズに合わせてカロリーを返す() {
		// コーヒーの一覧を取得
		CoffeeListParser parser = new CoffeeListParser(getContext());
		ArrayList<SimpleCoffeeModel> coffeeLists = parser.getCoffeeList();

		final CalorieFinder finder = new CalorieFinder(getContext());
		
		for (SimpleCoffeeModel model : coffeeLists) {
			CoffeeFinder coffeeFinder = new CoffeeFinder(getContext(),
					model.coffeeName);
			Coffee coffee = coffeeFinder.find();

			int count = coffee.size.size();
			for (int i = 0; i < count; i++) {
				// コーヒーのサイズに合わせてカロリー
				Calorie actualCalorie = finder.getCoffeeSizeCalorie(coffee, coffee.size.get(i));

				String errorMessage = String.format(Locale.getDefault(),
						"%s のカロリーが取得できません", model.coffeeName.getCoffeeName());
				
				// カロリーが取得出来ているか確認する
				assertNotSame(errorMessage, 0, actualCalorie.getCalorie());

				// 一応コーヒーの名前を出力して確認しておく
				Log.d("test", "Calorie is " + actualCalorie.getCalorie());
			}
		}
	}
}
