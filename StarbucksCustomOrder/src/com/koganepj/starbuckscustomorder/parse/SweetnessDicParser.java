package com.koganepj.starbuckscustomorder.parse;

import java.util.HashMap;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.ItemName;
import com.koganepj.starbuckscustomorder.model.Sweetness;

public class SweetnessDicParser {
	private static final String SWEETNESS_DIC = "SweetnessDic";

	/**
	 * Plistから甘さをパースしHashMapとして返す
	 * 
	 * @param  rootDict 
	 * @return HashMap<商品名, 甘さ(0~4)>
	 */
	public static HashMap<ItemName, Sweetness> parse(NSDictionary rootDict) {
		final NSDictionary sweetnessNSDict = (NSDictionary) (rootDict
				.objectForKey(SWEETNESS_DIC));

		final HashMap<ItemName, Sweetness> sweetnessDic = NSDictionaryHelper
				.nsDictToHashMap(sweetnessNSDict);

		return sweetnessDic;
	}

}
