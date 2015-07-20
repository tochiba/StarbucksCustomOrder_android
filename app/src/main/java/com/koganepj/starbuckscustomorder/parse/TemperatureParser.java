package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Temperature;

public class TemperatureParser {
	private static final String ITEM_TEMPERATURE = "Temperature";

	/**
	 * 温度のリストを取得
	 * 
	 * @param targetDict コーヒーの詳細情報が格納されたNSDictionary
	 * @return
	 */
	public static ArrayList<Temperature> parse(NSDictionary targetDict) {
		final ArrayList<Temperature> temperatures = new ArrayList<Temperature>();

		final NSArray array = (NSArray) targetDict
				.objectForKey(ITEM_TEMPERATURE);
		for (NSObject element : array.getArray()) {
			temperatures.add(new Temperature(element.toString()));
		}
		
		return temperatures;
	}

}
