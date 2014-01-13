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

import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.parse.CoffeeListParser;
import com.koganepj.starbuckscustomorder.view.ranking.adapter.RankingAdapter;
import com.koganepj.starbuckscustomorder.view.ranking.social.SocialRankingLoaderCallback;
import com.koganepj.starbuckscustomorder.view.ranking.social.SocialRankingModel;

public class RankingFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, null);
        
        //データを読み込み
        CoffeeListParser parser = new CoffeeListParser(getActivity());
        ArrayList<SimpleCoffeeModel> coffeeList = parser.getCoffeeList();
        
        
        //ListViewの初期設定
        ListView listView = (ListView)view.findViewById(R.id.ListMenu);
        RankingAdapter adapter = new RankingAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setEmptyView(view.findViewById(R.id.empty));
        listView.setOnItemClickListener(new OnRowClickListener());
        
        //ソーシャルランキングの読み込みを行っておく
        //TODO コードが整理されてきたらActivity読み込みの時点に移動！
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
