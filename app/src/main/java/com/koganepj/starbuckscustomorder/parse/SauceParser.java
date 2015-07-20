package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Sauce;

public class SauceParser {
	private static final String ITEM_SAUCE = "Sauce";

	public static ArrayList<Sauce> parse(NSDictionary targetDict) {
		final ArrayList<Sauce> sauces = new ArrayList<Sauce>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_SAUCE);
		for (NSObject element : array.getArray()) {
			sauces.add(new Sauce(element.toString()));
		}
		
		return sauces;
	}
}
