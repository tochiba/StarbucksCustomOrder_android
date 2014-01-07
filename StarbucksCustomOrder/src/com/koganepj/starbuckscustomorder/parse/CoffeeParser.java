package com.koganepj.starbuckscustomorder.parse;

import android.text.TextUtils;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Calorie;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Photo;
import com.koganepj.starbuckscustomorder.model.Price;
import com.koganepj.starbuckscustomorder.model.Shot;
import com.koganepj.starbuckscustomorder.model.Size;
import com.koganepj.starbuckscustomorder.model.Temperature;
import com.koganepj.starbuckscustomorder.model.Type;

public class CoffeeParser {
	// Plistのコーヒー一覧のKey
	private static final String ITEM_ARRAY = "ItemArray";

	private static final String ITEM_BASE = "Base";
	private static final String ITEM_SYRUP = "Syrup";
	private static final String ITEM_SAUCE = "Sauce";
	private static final String ITEM_POWDER = "Powder";
	private static final String ITEM_JELLY = "Jelly";
	private static final String ITEM_MILK = "Milk";
	private static final String ITEM_WHIPPEDCREAM = "WhippedCream";
	private static final String ITEM_ESPRESSO = "Espresso";
	private static final String ITEM_RECOMMEND = "Recommend";

	/**
	 * Plistから指定されたコーヒー名の要素をNSDictionaryとして取得する
	 * 
	 * @return NSDictionary
	 */
	public NSDictionary searchTargetNSDict(NSDictionary rootDict,
			CoffeeName targetName) {
		final NSArray itemNSArray = (NSArray) (rootDict
				.objectForKey(ITEM_ARRAY));

		NSDictionary resultDict = null;
		for (NSObject item : itemNSArray.getArray()) {
			final NSDictionary dict = (NSDictionary) item;
			final String itemName = NSDictionaryHelper.stringForKey(dict,
					CoffeeName.ITEM_NAME);
			if (TextUtils.equals(targetName.getCoffeeName(), itemName)) {
				return dict;
			}
		}

		return resultDict;
	}

	/**
	 * searchTargetNSDictで取得したNSDictionaryをCoffeeクラスにパースする
	 * 
	 * @param dict
	 * @return Coffeeクラス
	 */
	public Coffee parseCoffee(NSDictionary dict) {
		final Coffee coffee = new Coffee();

		coffee.type = new Type(NSDictionaryHelper.stringForKey(dict,
				Type.ITEM_TYPE));
		coffee.name = new CoffeeName(NSDictionaryHelper.stringForKey(dict,
				CoffeeName.ITEM_NAME));
		coffee.photo = new Photo(NSDictionaryHelper.stringForKey(dict,
				Photo.ITEM_PHOTO));
		coffee.calorie = new Calorie(NSDictionaryHelper.intForKey(dict,
				Calorie.ITEM_CALORIE));
		coffee.price = new Price(NSDictionaryHelper.intForKey(dict,
				Price.ITEM_PRICE));
		coffee.temperature = new Temperature(
				NSDictionaryHelper.stringListForKey(dict,
						Temperature.ITEM_TEMPERATURE));
		coffee.size = new Size(NSDictionaryHelper.stringListForKey(dict,
				Size.ITEM_SIZE));
		coffee.shot = new Shot(NSDictionaryHelper.integerListForKey(dict,
				Shot.ITEM_SHOT));
		coffee.base = NSDictionaryHelper.stringListForKey(dict, ITEM_BASE);
		coffee.syrup = NSDictionaryHelper.stringListForKey(dict, ITEM_SYRUP);
		coffee.sauce = NSDictionaryHelper.stringListForKey(dict, ITEM_SAUCE);
		coffee.powder = NSDictionaryHelper.stringListForKey(dict, ITEM_POWDER);
		coffee.jelly = NSDictionaryHelper.stringListForKey(dict, ITEM_JELLY);
		coffee.milk = NSDictionaryHelper.stringListForKey(dict, ITEM_MILK);
		coffee.whippedCream = NSDictionaryHelper.stringListForKey(dict,
				ITEM_WHIPPEDCREAM);
		coffee.espresso = NSDictionaryHelper.stringListForKey(dict,
				ITEM_ESPRESSO);
		coffee.recommend = NSDictionaryHelper.stringListForKey(dict,
				ITEM_RECOMMEND);

		return coffee;
	}
}
