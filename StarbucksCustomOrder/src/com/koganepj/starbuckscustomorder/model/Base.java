package com.koganepj.starbuckscustomorder.model;

import java.util.ArrayList;

public class Base {
	public static final String ITEM_BASE = "Base";

	private ArrayList<String> mBaseList;
	private String mBase;

	public Base(ArrayList<String> baseList) {
		mBaseList = baseList;
	}
	
	public ArrayList<String> getBaseList() {
		return mBaseList;
	}

	public String getBase() {
		return mBase;
	}

	public void setBase(String base) {
		mBase = base;
	}
}
