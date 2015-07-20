package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Syrup;

public class SyrupParser {
	private static final String ITEM_SYRUP = "Syrup";
	
	public static ArrayList<Syrup> parse(NSDictionary targetDict) {
		final ArrayList<Syrup> syrups = new ArrayList<Syrup>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_SYRUP);
		for (NSObject element : array.getArray()) {
			syrups.add(new Syrup(element.toString()));
		}
		
		return syrups;
	}
}
