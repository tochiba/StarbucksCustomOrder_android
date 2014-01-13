package com.koganepj.starbuckscustomorder.reading;

import android.content.Context;
import android.text.TextUtils;

import com.dd.plist.NSDictionary;
import com.koganepj.starbuckscustomorder.model.CustomizeCoffee;
import com.koganepj.starbuckscustomorder.parse.NSDictionaryHelper;

public class ReadingBuilder {
	private static final String READING_DICT = "ReadingDic";

	private Context mContext;
	private NSDictionary mReadingDict;
	private CustomizeCoffee mCustomizeCoffee;
	private String mExShot;
	private String mNonSyrup;

	public ReadingBuilder(Context context, CustomizeCoffee customizeCoffee) {
		mContext = context;
		mCustomizeCoffee = customizeCoffee;
		mReadingDict = getReadingDict();
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
		String name = NSDictionaryHelper.stringForKey(mReadingDict, mCustomizeCoffee.coffee.name.getCoffeeName());
		if (TextUtils.isEmpty(name)) {
			return mCustomizeCoffee.coffee.name.getCoffeeName().replaceAll(" ", "");
		} 
		
		return name;
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
		String espresso = NSDictionaryHelper.stringForKey(mReadingDict,
				mCustomizeCoffee.espresso.getEspresso());
		if (TextUtils.equals("アドリストレットショット", espresso)) {
			mExShot = "アドリストレットショット";
			return "";
		}

		if (!TextUtils.equals("アドショット", espresso)) {
			// 変更なし、リストレット
			return getReadingFormat(espresso);
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
		if (mCustomizeCoffee.syrup == null) {
			return "";
		}
		String readingSyrup = NSDictionaryHelper.stringForKey(mReadingDict,
				mCustomizeCoffee.syrup.getSyrup());

		if (TextUtils.equals("ノンシロップ", readingSyrup)) {
			mNonSyrup = "ノンシロップ";
			return "";
		}

		return getReadingFormat(readingSyrup);
	}

	private String getMilk() {
		if (mCustomizeCoffee.milk == null) {
			return "";
		}
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				mReadingDict, mCustomizeCoffee.milk.getMilk()));
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
		if (mCustomizeCoffee.sauce == null) {
			return "";
		}
 		return getReadingFormat(NSDictionaryHelper.stringForKey(
				mReadingDict, mCustomizeCoffee.sauce.getSauce()));
	}

	private String getPowder() {
		if (mCustomizeCoffee.powder == null) {
			return "";
		}
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				mReadingDict, mCustomizeCoffee.powder.getPowder()));

	}

	private String getBase() {
		if (mCustomizeCoffee.base == null) {
			return "";
		}
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				mReadingDict, mCustomizeCoffee.base.getBase()));
	}

	private String getJelly() {
		if (mCustomizeCoffee.jelly == null) {
			return "";
		}
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				mReadingDict, mCustomizeCoffee.jelly.getJelly()));
	}

	private String getWhippedCream() {
		return getReadingFormat(NSDictionaryHelper.stringForKey(
				mReadingDict,
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
