package com.koganepj.starbuckscustomorder.model;

import java.util.ArrayList;

public class Temperature {
	public static final String ITEM_TEMPERATURE = "Temperature";
	
	private ArrayList<String> mTemperatureList;
	private String mTemperature;
	
	public Temperature(ArrayList<String> temperatures) {
		mTemperatureList = temperatures;
	}
	
	/**
	 * 選択できる温かさを返す
	 * 
	 * @return 温かさの一覧
	 */
	public ArrayList<String> getTemperatureList() {
		return mTemperatureList;
	}
	
	/**
	 * 選択された温かさをセットする
	 * 
	 * @param temperature
	 */
	public void setTemperature(String temperature) {
		mTemperature = temperature;
	}

	/**
	 *	選択された温かさを取得する
	 * 
	 * @return ホット | コールド
	 */
	public String getTemperature() {
		return mTemperature;
	}
}
