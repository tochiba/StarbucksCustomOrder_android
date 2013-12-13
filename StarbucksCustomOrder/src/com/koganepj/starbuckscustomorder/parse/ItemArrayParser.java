package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.ItemModel;

public class ItemArrayParser {
	private static final String ITEM_ARRAY = "ItemArray";
	
	/**
	 * PlistからItemArrayキーをJavaオブジェクトにパースする
	 * 
	 * @param rootDict
	 * @return
	 */
	public static ArrayList<ItemModel> parse(NSDictionary rootDict) {
		final ArrayList<ItemModel> itemList = new ArrayList<ItemModel>();
		final NSArray itemNSArray = (NSArray) (rootDict
				.objectForKey(ITEM_ARRAY));

		for (NSObject item : itemNSArray.getArray()) {
			final NSDictionary dict = (NSDictionary) item;

			final ItemModel model = new ItemModel();
			model.type = NSDictionaryHelper.stringForKey(dict,
					ItemModel.Key.ITEM_TYPE);
			model.name = NSDictionaryHelper.stringForKey(dict,
					ItemModel.Key.ITEM_NAME);
			model.photo = NSDictionaryHelper.stringForKey(dict,
					ItemModel.Key.ITEM_PHOTO);
			model.calorie = NSDictionaryHelper.intForKey(dict,
					ItemModel.Key.ITEM_CALORIE);
			model.price = NSDictionaryHelper.intForKey(dict,
					ItemModel.Key.ITEM_PRICE);
			model.temperature = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_TEMPERATURE);
			model.size = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_SIZE);
			model.shot = NSDictionaryHelper.integerListForKey(dict,
					ItemModel.Key.ITEM_SHOT);
			model.base = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_BASE);
			model.syrup = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_SYRUP);
			model.sauce = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_SAUCE);
			model.powder = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_POWDER);
			model.jelly = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_JELLY);
			model.milk = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_MILK);
			model.whippedCream = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_WHIPPEDCREAM);
			model.espresso = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_ESPRESSO);
			model.recommend = NSDictionaryHelper.stringListForKey(dict,
					ItemModel.Key.ITEM_RECOMMEND);

			itemList.add(model);
		}

		return itemList;
	}

}
