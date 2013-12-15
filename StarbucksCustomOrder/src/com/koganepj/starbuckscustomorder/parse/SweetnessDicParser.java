package com.koganepj.starbuckscustomorder.parse;

import java.util.HashMap;

import com.dd.plist.NSDictionary;

public class SweetnessDicParser {
	private static final String SWEETNESS_DIC = "SweetnessDic";

	/**
	 * Plistから甘さをパースしHashMapとして返す
	 * 
	 * @param  rootDict 
	 * @return HashMap<商品名, 甘さ(0~4)>
	 */
	public static HashMap<String, Integer> parse(NSDictionary rootDict) {
		final NSDictionary sweetnessNSDict = (NSDictionary) (rootDict
				.objectForKey(SWEETNESS_DIC));

		final HashMap<String, Integer> sweetnessDic = NSDictionaryHelper
				.nsDictToIntHashMap(sweetnessNSDict);

		return sweetnessDic;
	}

}
