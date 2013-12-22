package com.koganepj.starbuckscustomorder.model;

import java.lang.reflect.Field;

import com.koganepj.starbuckscustomorder.R.drawable;

public class Photo {
	public static final String ITEM_PHOTO = "Photo";
	private int resourceId;

	public Photo(String fileName) {
		// ファイル名からリソースIDに変換
		final drawable drawable = new drawable();
		int resourceId;
		try {
			// Plistで管理されてる画像ファイル名をLowerCaseに変換して、drawableフォルダの画像ファイル名と一致させる
			String[] splitFileName = fileName.toLowerCase().split("\\.");
			Field field = drawable.getClass().getField(splitFileName[0]);
			resourceId = field.getInt(drawable);
		} catch (NoSuchFieldException e) {
			resourceId = 0;
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			resourceId = 0;
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			resourceId = 0;
			e.printStackTrace();
		}
		this.resourceId = resourceId;
	}

	public int getPhoto() {
		return resourceId;
	}
}
