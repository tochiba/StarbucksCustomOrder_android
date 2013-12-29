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
	 * Plistから甘さをパースしHashMapとして返す
	 * 
	 * @param rootDict
	 * @return HashMap<商品名, 甘さ(0~4)>
	 */
	public static HashMap<String, Integer> parse(NSDictionary rootDict) {
		final NSDictionary sweetnessNSDict = (NSDictionary) (rootDict
				.objectForKey(SWEETNESS_DIC));

		final HashMap<String, Integer> sweetnessDic = NSDictionaryHelper
				.nsDictToIntHashMap(sweetnessNSDict);

		return sweetnessDic;
	}

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
