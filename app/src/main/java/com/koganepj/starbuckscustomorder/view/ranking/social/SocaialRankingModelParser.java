package com.koganepj.starbuckscustomorder.view.ranking.social;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.koganepj.starbuckscustomorder.model.CoffeeName;

class SocaialRankingModelParser {
    
    private JSONObject mJsonObject;
    
    SocaialRankingModelParser(JSONObject object) {
        mJsonObject = object;
    }
    
    ArrayList<SocialRankingModel> parseList() {
        ArrayList<SocialRankingModel> result = new ArrayList<SocialRankingModel>();
        for (int i = 0; i < 10; i++) {
            String key = String.valueOf(i + 1);
            try {
                JSONObject singleData = mJsonObject.getJSONObject(key);
                SocialRankingModel model = parse(singleData);
                result.add(model);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    SocialRankingModel parse(JSONObject object) throws JSONException {
        int rank = object.getInt("rank");
        CoffeeName name = new CoffeeName(object.getString("name"));
        return new SocialRankingModel(rank, name);
    }
    
}
