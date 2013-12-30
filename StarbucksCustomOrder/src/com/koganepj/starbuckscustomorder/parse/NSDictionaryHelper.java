package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.res.AssetManager;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.dd.plist.NSString;
import com.dd.plist.PropertyListParser;
import com.koganepj.starbuckscustomorder.model.CoffeeName;

public class NSDictionaryHelper {
	private static final String PLIST_NAME = "StarbucksCustomList.plist";
	
	/**
	 * RootのDictionaryを返す
	 * 
	 * @return NSDictionary
	 */
	public static NSDictionary returnRootDictionary(Context context) {
		try {
			final AssetManager manager = context.getAssets();
			return (NSDictionary) PropertyListParser.parse(manager
					.open(PLIST_NAME));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * NSDictionaryから指定されたKeyの文字列を返す
	 * 
	 * @param dict
	 * @param key
	 * @return String
	 */
	public static String stringForKey(NSDictionary dict, String key) {
		return ((NSString) dict.objectForKey(key)).getContent();
	}

	/**
	 * NSDictionaryから指定されたKeyの整数値を返す
	 * 
	 * @param dict
	 * @param key
	 * @return
	 */
	public static int intForKey(NSDictionary dict, String key) {
		final String str = stringForKey(dict, key);
		return Integer.parseInt(str);
	}

	/**
	 * NSDictionaryから指定されたKeyの文字列型のリストを返す
	 * 
	 * @param dict
	 * @param key
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> stringListForKey(NSDictionary dict,
			String key) {
		final ArrayList<String> list = new ArrayList<String>();
		final NSArray array = (NSArray) dict.objectForKey(key);
		for (NSObject element : array.getArray()) {
			list.add(element.toString());
		}

		return list;
	}

	/**
	 * NSDictionaryから指定されたKeyの整数値型リストを返す
	 * 
	 * @param dict
	 * @param key
	 * @return ArrayList<Integer>
	 */
	public static ArrayList<Integer> integerListForKey(NSDictionary dict,
			String key) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		final NSArray array = (NSArray) dict.objectForKey(key);
		for (NSObject element : array.getArray()) {
			list.add(Integer.parseInt(element.toString()));
		}
		return list;
	}

	/**
	 * KeyがString,ValueがIntegerのHashMapを返す
	 * 
	 * @param dict
	 * @return HashMap<String, Intenger>
	 */
	public static HashMap<String, Integer> nsDictToIntHashMap(NSDictionary dict) {
		final HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		final String[] allKeys = dict.allKeys();

		for (String key : allKeys) {
			hashMap.put(key, intForKey(dict, key));
		}
		return hashMap;
	}
	
	/**
	 * 引数で指定されたNSDictionaryからtargetLevelを探し、
	 * ArrayListとして返す
	 * 
	 * @param targetDict
	 * @param targetLevel
	 * @return
	 */
	public static ArrayList<CoffeeName> coffeeNameListForInt(NSDictionary targetDict, int target) {
		final ArrayList<CoffeeName> resultList = new ArrayList<CoffeeName>();
		final String[] allKeys = targetDict.allKeys();
		for (String key : allKeys) {
			int level = NSDictionaryHelper.intForKey(targetDict, key);

			if (level != target) {
				continue;
			}
			CoffeeName name = new CoffeeName(key);
			resultList.add(name);
		}

		return resultList;
	}
}