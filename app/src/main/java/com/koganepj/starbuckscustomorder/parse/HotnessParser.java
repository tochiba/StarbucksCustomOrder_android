package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Hotness;

public class HotnessParser {
	private static final String TEMPERATURE_DIC = "TemperatureDic";

	/**
	 * 指定された甘さのコーヒー名をArrayListで返す
	 * 
	 * @param rootDict
	 * @param hotness
	 * @return
	 */
	public static ArrayList<CoffeeName> find(NSDictionary rootDict,
			Hotness hotness) {
		final NSDictionary hotnessNSDict = (NSDictionary) (rootDict
				.objectForKey(TEMPERATURE_DIC));

		// NSDictionaryから指定された温かさのコーヒー名を取得する
		final int targetLevel = hotness.getLevel();
		final ArrayList<CoffeeName> coffeeNameList = NSDictionaryHelper
				.coffeeNameListForInt(hotnessNSDict, targetLevel);
		
		return coffeeNameList;
	}
}
