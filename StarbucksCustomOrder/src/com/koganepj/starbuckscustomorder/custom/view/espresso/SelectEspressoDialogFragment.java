package com.koganepj.starbuckscustomorder.custom.view.espresso;

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
import com.koganepj.starbuckscustomorder.model.Espresso;

public class SelectEspressoDialogFragment extends DialogFragment {
    
    public static final String KEY_ITEMS = "key_items";
    public static final String KEY_SELECTED_ITEM = "key_selected";
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        
        Bundle arguments = getArguments();
        
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        ListView listView = (ListView)inflater.inflate(R.layout.layout_custom_customize_select_list_dialog, null);
        CustomizeAdapter adapter = new CustomizeAdapter(getActivity());
        listView.setAdapter(adapter);
        
        @SuppressWarnings("unchecked")
        ArrayList<Espresso> espressos = (ArrayList<Espresso>)arguments.getSerializable(KEY_ITEMS);
        Espresso selectedEspresso = (Espresso)arguments.getSerializable(KEY_SELECTED_ITEM);
        
        for (Espresso espresso : espressos) {
            boolean isSelected = espresso.equals(selectedEspresso) ? true : false;
            adapter.add(new CustomizeNameModel(espresso.getEspresso(), isSelected));
        }
        
        CustomActivity activity = (CustomActivity)getActivity();
        listView.setOnItemClickListener(new OnSelectEspressoItemClickListener(activity, this, espressos));
        
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(listView);
        return builder.create();
    }
    
}
