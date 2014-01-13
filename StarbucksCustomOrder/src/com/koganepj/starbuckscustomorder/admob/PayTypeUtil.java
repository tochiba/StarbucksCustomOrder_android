package com.koganepj.starbuckscustomorder.admob;

import android.content.Context;
import android.text.TextUtils;

public class PayTypeUtil {
	private static final String PAY_PACKAGE_NAME = "com.koganepj.starbuckscustomorder";

	public static boolean isPayVersion(Context context) {
		if (TextUtils.equals(context.getPackageName(), PAY_PACKAGE_NAME)) {
			return true;
		} else {
			return false;
		}
	}
}
