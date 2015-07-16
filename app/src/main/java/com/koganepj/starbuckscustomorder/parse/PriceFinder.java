package com.koganepj.starbuckscustomorder.parse;

import android.content.Context;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.Price;
import com.koganepj.starbuckscustomorder.model.Size;

public class PriceFinder {
	private static final String PRICE_DICT = "PriceDic";
	private static final int SIZE_PRICE = 40;
	
	private NSDictionary mPriceDict;

	public PriceFinder(Context context) {
		// 値段の辞書を取得
		mPriceDict = getPriceDict(context);
	}

	public Price getPrice(String name) {
		final int value = NSDictionaryHelper.intForKey(mPriceDict, name);

		return new Price(value);
	}
	
	/**
	 *	サイズに合わせたコーヒーの値段を返す 
	 * 
	 * @param coffee 選択されたコーヒー
	 * @param currentSize 選択されたサイズ
	 * @return 選択されたサイズの値段
	 */
	public Price getSizePrice(Coffee coffee, Size currentSize) {
		int index = coffee.size.indexOf(currentSize);
		return new Price(coffee.price.getPrice() + index * SIZE_PRICE);
	}

	NSDictionary getPriceDict(Context context) {
		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(context);
		return (NSDictionary) (rootDict.objectForKey(PRICE_DICT));
	}
}
