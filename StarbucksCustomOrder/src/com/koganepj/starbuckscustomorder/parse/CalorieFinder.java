package com.koganepj.starbuckscustomorder.parse;

import android.content.Context;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.Calorie;

public class CalorieFinder {
	private static final String CALORIE_DICT = "CalorieDic";
	Context mContext;

	public CalorieFinder(Context context) {
		mContext = context;
	}

	public Calorie getCalorie(String name) {
		final NSDictionary calorieDict = getCalorieDict();
		final int value = NSDictionaryHelper.intForKey(calorieDict, name);

		return new Calorie(value);
	}

	private NSDictionary getCalorieDict() {
		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(mContext);
		return (NSDictionary) (rootDict.objectForKey(CALORIE_DICT));
	}
}
