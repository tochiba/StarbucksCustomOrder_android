package com.koganepj.starbuckscustomorder.model;

import java.util.ArrayList;

public class ItemModel {
	public String type;
	public String name;
	public String photo;
	public int calorie;
	public int price;
	public ArrayList<String> temperature;
	public ArrayList<String> size;
	public ArrayList<Integer> shot;
	public ArrayList<String> base;
	public ArrayList<String> syrup;
	public ArrayList<String> sauce;
	public ArrayList<String> powder;
	public ArrayList<String> jelly;
	public ArrayList<String> milk;
	public ArrayList<String> whippedCream;
	public ArrayList<String> espresso;
	public ArrayList<String> recommend;
	
	public class Key {
		public static final String ITEM_TYPE = "Type";
		public static final String ITEM_NAME = "Name";
		public static final String ITEM_PHOTO = "Photo";
		public static final String ITEM_CALORIE = "Calorie";
		public static final String ITEM_PRICE = "Price";
		public static final String ITEM_TEMPERATURE = "Temperature";
		public static final String ITEM_SIZE = "Size";
		public static final String ITEM_SHOT = "Shot";
		public static final String ITEM_BASE = "Base";
		public static final String ITEM_SYRUP = "Syrup";
		public static final String ITEM_SAUCE = "Sauce";
		public static final String ITEM_POWDER = "Powder";
		public static final String ITEM_JELLY = "Jelly";
		public static final String ITEM_MILK = "Milk";
		public static final String ITEM_WHIPPEDCREAM = "WhippedCream";
		public static final String ITEM_ESPRESSO = "Espresso";
		public static final String ITEM_RECOMMEND = "Recommend";
	}

}
