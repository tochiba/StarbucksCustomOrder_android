package com.koganepj.starbuckscustomorder.parse;

import android.content.Context;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.Price;

public class PriceFinder {
	private static final String PRICE_DICT = "PriceDic";
	Context mContext;

	public PriceFinder(Context context) {
		mContext = context;
	}

	public Price getPrice(String name) {
		final NSDictionary priceDict = getPriceDict();
		final int value = NSDictionaryHelper.intForKey(priceDict, name);

		return new Price(value);
	}

	private NSDictionary getPriceDict() {
		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(mContext);
		return (NSDictionary) (rootDict.objectForKey(PRICE_DICT));
	}
}
