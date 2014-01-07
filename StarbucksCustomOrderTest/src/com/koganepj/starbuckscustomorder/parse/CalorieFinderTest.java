package com.koganepj.starbuckscustomorder.parse;

import java.util.Map.Entry;

import android.test.AndroidTestCase;
import android.util.Log;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Calorie;

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
}
