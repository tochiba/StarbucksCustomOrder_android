package com.koganepj.starbuckscustomorder.model;

public class Photo {
	public static final String ITEM_PHOTO = "Photo";
	private String fileName;
	
	public Photo(String fileName) {
		this.fileName = fileName;
	}
	
	public String getPhoto() {
		return fileName;
	}
}
