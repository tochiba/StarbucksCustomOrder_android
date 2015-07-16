package com.koganepj.starbuckscustomorder.parse;

import java.util.HashMap;

import android.content.Context;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.Calorie;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.Size;

public class CalorieFinder {
	private static final String CALORIE_DICT = "CalorieDic";
	private static final HashMap<String, Integer> COFFEE_VOLUME = new HashMap<String, Integer>(); 
	static {
		COFFEE_VOLUME.put("Short", 240);
		COFFEE_VOLUME.put("Tall", 350);
		COFFEE_VOLUME.put("Grande", 470);
		COFFEE_VOLUME.put("Venti", 590);
		COFFEE_VOLUME.put("ワンサイズ", -1);
	}
	
	private NSDictionary mCalorieDict;
	
	public CalorieFinder(Context context) {
		mCalorieDict = getCalorieDict(context);
		
	}

	public Calorie getCalorie(String name) {
		final int value = NSDictionaryHelper.intForKey(mCalorieDict, name);

		return new Calorie(value);
	}
	
	public Calorie getCoffeeSizeCalorie(Coffee coffee, Size currentSize) {
		// 選択されたコーヒーの容量を取得
		int currentValue = COFFEE_VOLUME.get(currentSize.getSize());
		if (currentValue == -1) {
			// ワンサイズの場合は、カロリーをそのまま返す
			return new Calorie(coffee.calorie.getCalorie());
		}
		
		// 1mlあたりのカロリーを取得
		double caloriePerValue = ((double)coffee.calorie.getCalorie()) / ((double)COFFEE_VOLUME.get(coffee.size.get(0).getSize()));
		return new Calorie((int)(currentValue * caloriePerValue));
	}

	NSDictionary getCalorieDict(Context context) {
		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(context);
		return (NSDictionary) (rootDict.objectForKey(CALORIE_DICT));
	}
}
