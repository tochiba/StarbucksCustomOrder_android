package com.koganepj.starbuckscustomorder.model;

import java.util.ArrayList;

public class Coffee {
	public Type type; // 種別
	public CoffeeName name; // コーヒー名
	public Photo photo; // 画像
	public Calorie calorie; // カロリー
	public Price price; // 値段
	public Temperature temperature; // 温かさ(ホット | コールド)
	public Size size; // サイズ (ショート|トール|グランデ|ベンティ)
	public Shot shot; // ショット (コーヒーやサイズによってショット数が変わる)
	public Base base; // ベース
	public ArrayList<String> syrup; // シロップ
	public ArrayList<String> sauce; //　ソース
	public ArrayList<String> powder; // パウダー(チョコチップ)
	public ArrayList<String> jelly; // ジェリー
	public ArrayList<String> milk; // ミルク
	public ArrayList<String> whippedCream; // ホイップクリーム
	public ArrayList<String> espresso; // エスプレッソ
	public ArrayList<String> recommend; // おすすめ
}
