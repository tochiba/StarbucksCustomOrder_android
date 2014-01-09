package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Size;

public class SizeParser {
	private static final String ITEM_SIZE = "Size";
	
	public static ArrayList<Size> parse(NSDictionary targetDict) {
		final ArrayList<Size> sizes = new ArrayList<Size>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_SIZE);
		for (NSObject element : array.getArray()) {
			sizes.add(new Size(element.toString()));
		}
		
		return sizes;
	}
}
