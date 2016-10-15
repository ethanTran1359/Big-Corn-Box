package com.example.rubit1359.bigcornbox.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by rubit1359 on 10/15/2016.
 */

public class AlertDialogFragment extends DialogFragment {
    //Supply keys for the Bundle
    public static final String TITLE_ID = "title";
    public static final String MESSAGE_ID = "message";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle messages = getArguments();
        Context context = getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("OK", null);

        if (messages != null) {
            builder.setTitle(messages.getString(TITLE_ID, "Oops!"));
            builder.setMessage(messages.getString(MESSAGE_ID, "There was an error."));
        } else {
            builder.setTitle("Oops!");
            builder.setMessage("There was an error.");
        }

        return builder.create();
    }
}

