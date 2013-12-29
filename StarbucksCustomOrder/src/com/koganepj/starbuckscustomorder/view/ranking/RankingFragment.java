package com.koganepj.starbuckscustomorder.view.ranking;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.parse.CoffeeListParser;
import com.koganepj.starbuckscustomorder.view.ranking.adapter.RankingAdapter;
import com.koganepj.starbuckscustomorder.view.ranking.social.SocialRankingLoaderCallback;
import com.koganepj.starbuckscustomorder.view.ranking.social.SocialRankingModel;

public class RankingFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, null);
        
        //リストを読み込み
        CoffeeListParser parser = new CoffeeListParser(getActivity());
        ArrayList<SimpleCoffeeModel> coffeeList = parser.getCoffeeList();
        
        //アダプターをセット
        ListView listView = (ListView)view.findViewById(R.id.ListMenu);
        RankingAdapter adapter = new RankingAdapter(getActivity());
        listView.setAdapter(adapter);
        
        //ソーシャルランキングの読み込みを行っておく
        SocialRankingLoaderCallback callback = new SocialRankingLoaderCallback(getActivity());
        Loader<ArrayList<SocialRankingModel>> loader = getLoaderManager().initLoader(0, null, callback);
        loader.forceLoad();
        
        //ラジオボタンの動作設定
        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.RadioGroupMenuShowType);
        radioGroup.setOnCheckedChangeListener(new TypeSelectListener(adapter, coffeeList, callback));
        
        //初期表示
        radioGroup.check(R.id.RadioPrice);
        
        return view;
    }
    
}
