package com.koganepj.starbuckscustomorder.parse;

import java.util.HashMap;

import com.dd.plist.NSDictionary;

public class TemperatureDicParser {
	private static final String TEMPERATURE_DIC = "TemperatureDic";

	/**
	 * Plistから温度をパースしHashMapとして返す
	 * 
	 * @param  rootDict 
	 * @return HashMap<商品名, 温度(0~4)>
	 */
	public static HashMap<String, Integer> parse(NSDictionary rootDict) {
		final NSDictionary tempretureNSDict = (NSDictionary) (rootDict
				.objectForKey(TEMPERATURE_DIC));

		final HashMap<String, Integer> temperatureDic = NSDictionaryHelper
				.nsDictToIntHashMap(tempretureNSDict);

		return temperatureDic;
	}

}
