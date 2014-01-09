package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Milk;

public class MilkParser {
	private static final String ITEM_MILK = "Milk";

	public static ArrayList<Milk> parse(NSDictionary targetDict) {
		final ArrayList<Milk> milks = new ArrayList<Milk>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_MILK);
		for (NSObject element : array.getArray()) {
			milks.add(new Milk(element.toString()));
		}
		
		return milks;
	}
}
