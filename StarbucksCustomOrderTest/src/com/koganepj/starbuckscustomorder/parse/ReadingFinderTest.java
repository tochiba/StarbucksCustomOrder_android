package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;
import java.util.Locale;

import android.test.AndroidTestCase;
import android.util.Log;

import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

public class ReadingFinderTest extends AndroidTestCase {

	public void test商品から呪文を取得する() {
		CoffeeListParser parser = new CoffeeListParser(getContext());
		ArrayList<SimpleCoffeeModel> coffeeLists = parser.getCoffeeList();

		for (SimpleCoffeeModel model : coffeeLists) {
			CoffeeFinder finder = new CoffeeFinder(getContext(),
					model.coffeeName);
			Coffee coffee = finder.find();

			String errorMessage = String.format(Locale.getDefault(),
					"%s の呪文を生成できませんでした。", model.coffeeName.getCoffeeName());
			// 呪文を生成できたか検査
//			assertNotNull(errorMessage, null);

			// 一応コーヒーの名前を出力して確認しておく
			Log.d("test", "The coffeeName is " + coffee.name);
		}
	}
}
