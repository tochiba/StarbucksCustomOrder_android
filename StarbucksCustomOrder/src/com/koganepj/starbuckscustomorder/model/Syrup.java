package com.koganepj.starbuckscustomorder.model;

import java.util.ArrayList;

public class Syrup {
	public static final String ITEM_SYRUP = "Syrup";
	
	private ArrayList<String> mSyrupList;
	private String mSyrup;
	
	public Syrup(ArrayList<String> syrupList) {
		mSyrupList = syrupList;
	}
	
	public ArrayList<String> getSyrupList() {
		return mSyrupList;
	}

	public String getSyrup() {
		return mSyrup;
	}

	public void setSyrup(String mSyrup) {
		this.mSyrup = mSyrup;
	}
}
