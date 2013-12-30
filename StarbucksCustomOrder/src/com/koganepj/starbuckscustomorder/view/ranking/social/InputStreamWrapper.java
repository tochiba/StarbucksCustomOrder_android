package com.koganepj.starbuckscustomorder.view.ranking.social;

import java.io.InputStream;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

class InputStreamWrapper {
    
    private InputStream mInput;
    
    InputStreamWrapper(InputStream inputStream) {
        mInput = inputStream;
    }
    
    JSONObject toJsonObject() {
        //Inputを文字列に変換
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(mInput);
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        scanner.close();
        String jsonStr = builder.toString();
        
        try {
            return new JSONObject(jsonStr);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
