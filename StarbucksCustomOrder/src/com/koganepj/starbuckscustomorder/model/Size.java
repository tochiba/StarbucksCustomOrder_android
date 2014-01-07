package com.koganepj.starbuckscustomorder.model;

import java.util.ArrayList;

public class Size {
	public static final String ITEM_SIZE = "Size";

	private ArrayList<String> mSizeList;
	private String mSize;
	
	public Size(ArrayList<String> sizeList) {
		mSizeList = sizeList;
	}
	
	public ArrayList<String> getSiseList() {
		return mSizeList;
	}
	
	public String getSize() {
		return mSize;
	}
	public void setSize(String size) {
		mSize = size;
	}
}
