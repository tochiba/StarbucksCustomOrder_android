package com.koganepj.starbuckscustomorder.custom.view.sauce;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.custom.view.CustomizeAdapter;
import com.koganepj.starbuckscustomorder.custom.view.CustomizeNameModel;
import com.koganepj.starbuckscustomorder.model.Sauce;

public class SelectSauceDialogFragment extends DialogFragment {
    
    public static final String KEY_ITEMS = "key_items";
    public static final String KEY_SELECTED_ITEM = "key_selected";
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        
        //リストの用意
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        ListView listView = (ListView)inflater.inflate(R.layout.layout_custom_customize_select_list_dialog, null);
        CustomizeAdapter adapter = new CustomizeAdapter(getActivity());
        listView.setAdapter(adapter);
        
        //パラメータの受け取り
        Bundle arguments = getArguments();
        @SuppressWarnings("unchecked") ArrayList<Sauce> sauces = (ArrayList<Sauce>)arguments.getSerializable(KEY_ITEMS);
        Sauce selectedSauce = (Sauce)arguments.getSerializable(KEY_SELECTED_ITEM);
        
        //表示データを設定
        for (Sauce sauce : sauces) {
            boolean isSelected = sauce.equals(selectedSauce) ? true : false;
            adapter.add(new CustomizeNameModel(sauce.getSauce(), isSelected));
        }
        
        //クリックイベントを設定
        CustomActivity activity = (CustomActivity)getActivity();
        listView.setOnItemClickListener(new OnSelectSauceItemClickListener(activity, this, sauces));
        
        //ダイアログ表示
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(listView);
        return builder.create();
    }
    
}
