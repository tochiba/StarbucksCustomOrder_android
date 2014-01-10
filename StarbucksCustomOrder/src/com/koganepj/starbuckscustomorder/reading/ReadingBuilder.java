package com.koganepj.starbuckscustomorder.reading;

import android.content.Context;
import android.text.TextUtils;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.CustomizeCoffee;
import com.koganepj.starbuckscustomorder.parse.NSDictionaryHelper;

public class ReadingBuilder {
	private static final String READING_DICT = "ReadingDic";

	private Context mContext;
	private CustomizeCoffee mCustomizeCoffee;
	private String mExShot;
	private String mNonSyrup;

	public ReadingBuilder(Context context, CustomizeCoffee customizeCoffee) {
		mContext = context;
		mCustomizeCoffee = customizeCoffee;
	}

	public String getReading() {
		StringBuilder builder = new StringBuilder();
		builder.append(getTemperature());
		builder.append(getShot());
		builder.append(getSize());
		builder.append(getSyrup());
		builder.append(getMilk());
		
		// カスタム
		builder.append(getExShot());
		builder.append(getNonSyrup());
		builder.append(getSauce());
		builder.append(getPowder());
		builder.append(getBase());
		builder.append(getJelly());
		builder.append(getWhippedCream());

		// コーヒー名
		builder.append(getCoffeeName());

		return builder.toString();
	}

	private String getCoffeeName() {
		return NSDictionaryHelper.stringForKey(getReadingDict(),
				mCustomizeCoffee.coffee.name.getCoffeeName());
	}

	private String getTemperature() {
		if (TextUtils.equals("Frappuccino",
				mCustomizeCoffee.coffee.type.getType())) {
			// フラペチーノ系は使わない
			return "";
		}

		String readTemperacture = mCustomizeCoffee.temperature.getTemperature();

		if (TextUtils.equals("ホット", readTemperacture)) {
			// ホットはコールしない
			return "";
		}

		return String.format("%s ", readTemperacture);
	}

	 private String getShot() {
		 if (TextUtils.equals("アドリストレットショット", mCustomizeCoffee.espresso.getEspresso())) {
			 mExShot = "アドリストレットショット";
			 return "";
		 }
		 
		 if (!TextUtils.equals("アドショット", mCustomizeCoffee.espresso.getEspresso())) { 
			 // 変更なし、リストレット
			 return getReadingFormat(mCustomizeCoffee.espresso.getEspresso());
		 }
		
		String readingShot;
		switch (mCustomizeCoffee.shot.getShot()) {
		case 0:
			mExShot = "アドショット";
			readingShot = "";
			break;
		case 1:
			readingShot = "ダブル";
			break;
		case 2:
			readingShot = "トリプル";
			break;
		case 3:
			readingShot = "クアドロ";
			break;
		default:
			readingShot = "";
			break;
		}
		
		return getReadingFormat(readingShot);
	 }

	private String getSize() {
		// サイズはそのまま入れる
		return String.format("%s ", NSDictionaryHelper.stringForKey(
				getReadingDict(), mCustomizeCoffee.size.getSize()));
	}
	
	private String getSyrup() {
		String readingSyrup = NSDictionaryHelper.stringForKey(getReadingDict(), mCustomizeCoffee.syrup.getSyrup());
		
		if (TextUtils.equals("ノンシロップ", readingSyrup)) {
			mNonSyrup = "ノンシロップ";
			return "";
		} 
		
		return getReadingFormat(readingSyrup);
	}

	private String getMilk() {
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				getReadingDict(), mCustomizeCoffee.milk.getMilk()));
	}

	/**
	 * 以下、カスタマイズ項目
	 */
	
	private String getExShot() {
		return getReadingFormat(mExShot);
	}

	private String getNonSyrup() {
		return getReadingFormat(mNonSyrup);
	}
	
	private String getSauce() {
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				getReadingDict(), mCustomizeCoffee.sauce.getSauce()));
	}

	private String getPowder() {
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				getReadingDict(), mCustomizeCoffee.powder.getPowder()));

	}

	private String getBase() {
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				getReadingDict(), mCustomizeCoffee.base.getBase()));
	}

	private String getJelly() {
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				getReadingDict(), mCustomizeCoffee.jelly.getJelly()));
	}

	private String getWhippedCream() {
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				getReadingDict(),
				mCustomizeCoffee.whippedCream.getWhippedCream()));
	}

	private String getReadingFormat(String reading) {
		if (TextUtils.isEmpty(reading)) {
			return "";
		}

		return String.format("%s ", reading);
	}

	private NSDictionary getReadingDict() {
		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(mContext);
		return (NSDictionary) (rootDict.objectForKey(READING_DICT));
	}
}
