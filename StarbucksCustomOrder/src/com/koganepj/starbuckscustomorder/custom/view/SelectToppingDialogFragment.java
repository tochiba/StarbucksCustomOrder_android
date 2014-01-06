package com.koganepj.starbuckscustomorder.custom.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class SelectToppingDialogFragment extends DialogFragment {
    
    public static final String KEY_ITEMS = "key_items";
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(arguments.getSerializable(KEY_ITEMS).toString());
        return builder.create();
    }
    
}
