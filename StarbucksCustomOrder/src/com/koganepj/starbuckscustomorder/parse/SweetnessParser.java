package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.widget.SeekBar;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Hotness;
import com.koganepj.starbuckscustomorder.model.Sweetness;

public class SweetnessParser {
	private static final String SWEETNESS_DIC = "SweetnessDic";

	/**
	 * 指定された甘さからコーヒー名をArrayListで返す
	 * 
	 * @param rootDict
	 * @param sweetness
	 * @return
	 */
	public static ArrayList<CoffeeName> find(NSDictionary rootDict,
			Sweetness sweetness) {
		final NSDictionary sweetnessNSDict = (NSDictionary) (rootDict
				.objectForKey(SWEETNESS_DIC));

		// NSDictionaryから指定された甘さのコーヒーを取得する
		final int targetLevel = sweetness.getLevel();
		final ArrayList<CoffeeName> coffeeNameList = NSDictionaryHelper
				.coffeeNameListForInt(sweetnessNSDict, targetLevel);

		return coffeeNameList;
	}

}
