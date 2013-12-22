package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import android.content.Context;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Calorie;
import com.koganepj.starbuckscustomorder.model.CoffeeListModel;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Photo;
import com.koganepj.starbuckscustomorder.model.Price;
import com.koganepj.starbuckscustomorder.model.Type;

public class CoffeeListParser {
	/**
	 * PlistのKEY
	 */
	private static final String ITEM_ARRAY = "ItemArray";

	private NSDictionary mRootNSDictionary;
	private ArrayList<CoffeeListModel> mCoffeeList;

	public CoffeeListParser(Context context) {
		mRootNSDictionary = NSDictionaryHelper.returnRootDictionary(context);
	}

	/**
	 * 商品の一覧を返す
	 * 
	 * @return
	 */
	public ArrayList<CoffeeListModel> getCoffeeList() {
		if (mCoffeeList == null) {
			mCoffeeList = parse();
		}

		return mCoffeeList;
	}

	/**
	 * Plistから商品の一覧を取得する
	 * 
	 * @return
	 */
	private ArrayList<CoffeeListModel> parse() {
		final ArrayList<CoffeeListModel> coffeeList = new ArrayList<CoffeeListModel>();
		final NSArray itemNSArray = (NSArray) (mRootNSDictionary
				.objectForKey(ITEM_ARRAY));

		for (NSObject item : itemNSArray.getArray()) {
			final NSDictionary dict = (NSDictionary) item;
			final String type = NSDictionaryHelper.stringForKey(dict,
					Type.ITEM_TYPE);
			final String name = NSDictionaryHelper.stringForKey(dict,
					CoffeeName.ITEM_NAME);
			final String photo = NSDictionaryHelper.stringForKey(dict,
					Photo.ITEM_PHOTO);
			final int calorie = NSDictionaryHelper.intForKey(dict,
					Calorie.ITEM_CALORIE);
			final int price = NSDictionaryHelper.intForKey(dict,
					Price.ITEM_PRICE);

			final CoffeeListModel model = new CoffeeListModel();
			model.type = new Type(type);
			model.coffeeName = new CoffeeName(name);
			model.photo = new Photo(photo);
			model.calorie = new Calorie(calorie);
			model.price = new Price(price);
			coffeeList.add(model);
		}

		return coffeeList;
	}
}
