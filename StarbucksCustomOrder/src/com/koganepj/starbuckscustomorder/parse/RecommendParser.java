package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Recommend;

public class RecommendParser {
	private static final String ITEM_RECOMMEND = "Recommend";

	public static ArrayList<Recommend> parse(NSDictionary targetDict) {
		final ArrayList<Recommend> recommends = new ArrayList<Recommend>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_RECOMMEND);
		for (NSObject element : array.getArray()) {
			recommends.add(new Recommend(element.toString()));
		}
		
		return recommends;
	}
}
