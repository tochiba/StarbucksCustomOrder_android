package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Base;

public class BaseParser {
	private static final String ITEM_BASE = "Base";

	public static ArrayList<Base> parse(NSDictionary targetDict) {
		final ArrayList<Base> bases = new ArrayList<Base>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_BASE);
		for (NSObject element : array.getArray()) {
			bases.add(new Base(element.toString()));
		}
		
		return bases;
	}
}
