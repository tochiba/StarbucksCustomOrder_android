package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.WhippedCream;

public class WhippedCreamParser {
	private static final String ITEM_WHIPPEDCREAM = "WhippedCream";

	public static ArrayList<WhippedCream> parse(NSDictionary targetDict) {
		final ArrayList<WhippedCream> whippedCreams = new ArrayList<WhippedCream>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_WHIPPEDCREAM);
		for (NSObject element : array.getArray()) {
			whippedCreams.add(new WhippedCream(element.toString()));
		}
		
		return whippedCreams;
	}
}
