package com.koganepj.starbuckscustomorder.model;

import com.koganepj.starbuckscustomorder.reading.ReadingBuilder;

import android.content.Context;

public class CustomizeCoffee {
	public Coffee coffee;
	public Temperature temperature;
	public Size size;
	public Shot shot;
	public Base base;
	public Syrup syrup;
	public Sauce sauce;
	public Powder powder;
	public Jelly jelly;
	public Milk milk;
	public WhippedCream whippedCream;
	public Espresso espresso;
	public Recommend recommend;
	
	private ReadingBuilder mBuilder;

	public CustomizeCoffee(Context context, Coffee coffee, Temperature temperature, Size size,
			Shot shot, Base base, Syrup syrup, Sauce sauce, Powder powder,
			Jelly jelly, Milk milk, WhippedCream whippedCream,
			Espresso espresso, Recommend recommend) {
		this.coffee = coffee;
		this.temperature = temperature;
		this.size = size;
		this.shot = shot;
		this.base = base;
		this.syrup = syrup;
		this.sauce = sauce;
		this.powder = powder;
		this.jelly = jelly;
		this.milk = milk;
		this.whippedCream = whippedCream;
		this.espresso = espresso;
		this.recommend = recommend;
		
		mBuilder = new ReadingBuilder(context, this);
	}

	public String getJumon() {
		return mBuilder.getReading();
	}
	
	public String getHashTag() {
		return mBuilder.getReading().concat(" ");
	}

}
