package com.koganepj.starbuckscustomorder.model;

public class Temperature {
	private String temperature;
	
	public Temperature (String temperature) {
		this.temperature = temperature;
	}

	/**
	 *	選択された温かさを取得する
	 * 
	 * @return ホット | コールド
	 */
	public String getTemperature() {
		return this.temperature;
	}
}
