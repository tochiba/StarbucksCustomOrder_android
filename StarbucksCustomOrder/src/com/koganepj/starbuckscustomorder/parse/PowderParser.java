package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Powder;

public class PowderParser {
	private static final String ITEM_POWDER = "Powder";

	public static ArrayList<Powder> parse(NSDictionary targetDict) {
		final ArrayList<Powder> powders = new ArrayList<Powder>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_POWDER);
		for (NSObject element : array.getArray()) {
			powders.add(new Powder(element.toString()));
		}
		
		return powders;
	}
}
