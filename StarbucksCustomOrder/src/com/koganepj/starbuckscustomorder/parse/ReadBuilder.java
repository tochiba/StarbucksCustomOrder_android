package com.koganepj.starbuckscustomorder.parse;

import android.content.Context;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.Coffee;

public class ReadBuilder {
	private static final String READING_DICT = "ReadingDic";

	private Context mContext;
	private Coffee mCoffee;

	public ReadBuilder(Context context, Coffee coffee) {
		mContext = context;
		mCoffee = coffee;
	}

	public String getReading() {
		return null;
	}

	private String getCoffeeName() {
		return NSDictionaryHelper.stringForKey(getReadingDict(),
				mCoffee.name.getCoffeeName());
	}
	
	private String getTemperature() {
		return NSDictionaryHelper.stringForKey(getReadingDict(),
				mCoffee.temperature.getTemperature());
	}
	
	private String getSize() {
		return NSDictionaryHelper.stringForKey(getReadingDict(),
				mCoffee.size.getSize());
	}
	
	// TODO Shotは呪文に含まれる？
//	private String getShot() {
//		return NSDictionaryHelper.stringForKey(getReadingDict(),
//				mCoffee.shot.getShot());
//	}

	private String getBase() {
		return NSDictionaryHelper.stringForKey(getReadingDict(),
				mCoffee.base.getBase());
	}
	
	private NSDictionary getReadingDict() {
		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(mContext);
		return (NSDictionary) (rootDict.objectForKey(READING_DICT));
	}
}
