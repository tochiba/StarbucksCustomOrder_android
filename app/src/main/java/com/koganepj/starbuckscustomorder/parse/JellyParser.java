package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Jelly;

public class JellyParser {
	private static final String ITEM_JELLY = "Jelly";

	public static ArrayList<Jelly> parse(NSDictionary targetDict) {
		final ArrayList<Jelly> jellies = new ArrayList<Jelly>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_JELLY);
		for (NSObject element : array.getArray()) {
			jellies.add(new Jelly(element.toString()));
		}
		
		return jellies;
	}
}
