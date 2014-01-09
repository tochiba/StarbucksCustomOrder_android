package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Espresso;

public class EspressoParser {
	private static final String ITEM_ESPRESSO = "Espresso";

	public static ArrayList<Espresso> parse(NSDictionary targetDict) {
		final ArrayList<Espresso> espressos = new ArrayList<Espresso>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_ESPRESSO);
		for (NSObject element : array.getArray()) {
			espressos.add(new Espresso(element.toString()));
		}
		
		return espressos;
	}
}
