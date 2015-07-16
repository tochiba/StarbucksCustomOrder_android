package com.koganepj.starbuckscustomorder.view.ranking.social;

import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONObject;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class SocialRankingModelLoader extends AsyncTaskLoader<ArrayList<SocialRankingModel>> {
    
    public SocialRankingModelLoader(Context context) {
        super(context);
    }
    
    @Override
    public ArrayList<SocialRankingModel> loadInBackground() {
        //APIアクセスしてInputStreamを取得
        ApiLoader apiLoader = new ApiLoader();
        InputStream input = apiLoader.load();
        if (input == null) {
            return new ArrayList<SocialRankingModel>();
        }
        
        //Jsonオブジェクトとして取得
        InputStreamWrapper wrapper = new InputStreamWrapper(input);
        JSONObject json = wrapper.toJsonObject();
        if (json == null) {
            return new ArrayList<SocialRankingModel>();
        }
        
        //Jsonオブジェクトをパースしてモデルクラスのリストにする
        SocaialRankingModelParser parser = new SocaialRankingModelParser(json);
        return parser.parseList();
    }
    
}
