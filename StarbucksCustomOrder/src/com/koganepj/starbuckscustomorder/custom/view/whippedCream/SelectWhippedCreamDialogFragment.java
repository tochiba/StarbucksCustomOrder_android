package com.koganepj.starbuckscustomorder.custom.view.whippedCream;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.koganepj.starbuckscustomorder.custom.CustomActivity;
import com.koganepj.starbuckscustomorder.custom.view.CustomizeAdapter;
import com.koganepj.starbuckscustomorder.custom.view.CustomizeNameModel;
import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.WhippedCream;

public class SelectWhippedCreamDialogFragment extends DialogFragment {
    
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
        @SuppressWarnings("unchecked") ArrayList<WhippedCream> whippedCreams = (ArrayList<WhippedCream>)arguments.getSerializable(KEY_ITEMS);
        WhippedCream selectedWhippedCream = (WhippedCream)arguments.getSerializable(KEY_SELECTED_ITEM);
        
        //表示データを設定
        for (WhippedCream whippedCream : whippedCreams) {
            boolean isSelected = whippedCream.equals(selectedWhippedCream) ? true : false;
            adapter.add(new CustomizeNameModel(whippedCream.getWhippedCream(), isSelected));
        }
        
        //クリックイベントを設定
        CustomActivity activity = (CustomActivity)getActivity();
        listView.setOnItemClickListener(new OnSelectWhippedCreamItemClickListener(activity, this, whippedCreams));
        
        //ダイアログ表示
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(listView);
        return builder.create();
    }
    
}
