package com.koganepj.starbuckscustomorder.parse;

import android.content.Context;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.CoffeeName;

public class CoffeeFinder {
	private Context mContext;
	private CoffeeName mCoffeeName;
	
	public CoffeeFinder(Context context, CoffeeName targetName) {
		mContext = context;
		mCoffeeName = targetName;
	}

	/**
	 * コーヒーの詳細情報を取得する
	 * 
	 * @return
	 */
	public Coffee find() {
		final CoffeeParser parser = new CoffeeParser();
		final NSDictionary rootDict = NSDictionaryHelper.returnRootDictionary(mContext);
		final NSDictionary targetDict = parser.searchTargetNSDict(rootDict, mCoffeeName);
		
		return parser.parseCoffee(targetDict);
	}
}
