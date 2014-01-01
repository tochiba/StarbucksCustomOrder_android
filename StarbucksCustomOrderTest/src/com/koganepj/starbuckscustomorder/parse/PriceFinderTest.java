package com.koganepj.starbuckscustomorder.parse;

import java.util.Map.Entry;

import android.test.AndroidTestCase;
import android.util.Log;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Price;

public class PriceFinderTest extends AndroidTestCase {

	public void testカスタマイズ名から値段を取得する() {
		final PriceFinder finder = new PriceFinder(getContext());

		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(getContext());
		final NSDictionary priceDict = (NSDictionary) (rootDict
				.objectForKey("PriceDic"));
		// カスタマイズ名をループさせる
		for (Entry<String, NSObject> entry : priceDict.entrySet()) {

			// 検査
			final Price price = finder.getPrice(entry.getKey());
			String errorMessage = String.format("%s がみつかりません", entry.getKey());
			assertNotNull(errorMessage, price);

			Log.d("test", String.format("%s の値段は %s です.", entry.getKey(),
							price.getPrice()));
		}

	}
}
