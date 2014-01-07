package com.koganepj.starbuckscustomorder.model;

import java.util.ArrayList;

public class Shot {
	public static final String ITEM_SHOT = "Shot";
	
	private ArrayList<Integer> mShotList;
	private Integer mShot;
	
	public Shot(ArrayList<Integer> shotList) {
		mShotList = shotList;
	}

	public ArrayList<Integer> getShotList() {
		return mShotList;
	}

	public Integer getShot() {
		return mShot;
	}

	public void setShot(Integer shot) {
		mShot = shot;
	}
}
