package com.koganepj.starbuckscustomorder.flurry;

import java.util.HashMap;

import android.content.Context;

import com.flurry.android.FlurryAgent;

public class FlurryWrapper {
    
    public static final String API_KEY = "KMK3T7Y6T29BXV2DCD6M";
    
    public static void onStartSession(Context context) {
        FlurryAgent.onStartSession(context, API_KEY);
    }
    
    public static void onEndSession(Context context) {
        FlurryAgent.onEndSession(context);
    }
    
    public static void logEvent(String event) {
        FlurryAgent.logEvent(event);
    }
    
    public static void logEvent(String event, HashMap<String, String> params) {
        FlurryAgent.logEvent(event, params);
    }
    
}
