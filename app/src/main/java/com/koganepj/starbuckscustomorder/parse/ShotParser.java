package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Shot;

public class ShotParser {
	public static final String ITEM_SHOT = "Shot";

	public static ArrayList<Shot> parse(NSDictionary targetDict) {
		final ArrayList<Shot> shots = new ArrayList<Shot>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_SHOT);
		for (NSObject element : array.getArray()) {
			shots.add(new Shot(Integer.parseInt(element.toString())));
		}
		
		return shots;
	}
}
