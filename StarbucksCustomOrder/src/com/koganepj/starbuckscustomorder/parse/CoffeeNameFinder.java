package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Hotness;
import com.koganepj.starbuckscustomorder.model.Sweetness;

public class CoffeeNameFinder {
	private Context mContext;

	public CoffeeNameFinder(Context context) {
		mContext = context;
	}

	/**
	 * 引数の甘さと温かさからCoffeeNameを取得する
	 * 
	 * @param sweetness
	 *            甘さ
	 * @param hotness
	 *            温かさ
	 * @return 該当するコーヒーの名前 該当しない場合はnullを返す
	 */
	public CoffeeName findName(Sweetness sweetness, Hotness hotness) {
		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(mContext);
		final ArrayList<CoffeeName> hotnessList = HotnessParser.find(rootDict,
				hotness);
		final ArrayList<CoffeeName> sweetnessList = SweetnessParser.find(
				rootDict, sweetness);

		// 両リストから重複しているCoffeeNameを返す
		for (CoffeeName coffeeByHotness : hotnessList) {
			for (CoffeeName coffeeBySweetness : sweetnessList) {
				if (coffeeByHotness.getCoffeeName().equals(
						coffeeBySweetness.getCoffeeName())) {
					return coffeeByHotness;
				}
			}
		}
		return null;
	}
}
