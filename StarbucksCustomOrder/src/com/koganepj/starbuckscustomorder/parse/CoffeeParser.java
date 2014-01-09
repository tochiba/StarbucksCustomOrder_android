package com.koganepj.starbuckscustomorder.parse;

import android.text.TextUtils;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Base;
import com.koganepj.starbuckscustomorder.model.Calorie;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.CoffeeName;
import com.koganepj.starbuckscustomorder.model.Photo;
import com.koganepj.starbuckscustomorder.model.Price;
import com.koganepj.starbuckscustomorder.model.Shot;
import com.koganepj.starbuckscustomorder.model.Size;
import com.koganepj.starbuckscustomorder.model.Syrup;
import com.koganepj.starbuckscustomorder.model.Temperature;
import com.koganepj.starbuckscustomorder.model.Type;

public class CoffeeParser {
	// Plistのコーヒー一覧のKey
	private static final String ITEM_ARRAY = "ItemArray";

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
		coffee.temperatures = TemperatureParser.parse(dict);
		coffee.size = SizeParser.parse(dict);
		coffee.shot = ShotParser.parse(dict);
		coffee.base = BaseParser.parse(dict);
		coffee.syrup = SyrupParser.parse(dict);
		coffee.sauce = SauceParser.parse(dict);
		coffee.powder = PowderParser.parse(dict);
		coffee.jelly = JellyParser.parse(dict);
		coffee.milk = MilkParser.parse(dict);
		coffee.whippedCream = WhippedCreamParser.parse(dict);
		coffee.espresso = NSDictionaryHelper.stringListForKey(dict,
				ITEM_ESPRESSO);
		coffee.recommend = NSDictionaryHelper.stringListForKey(dict,
				ITEM_RECOMMEND);

		return coffee;
	}
}
