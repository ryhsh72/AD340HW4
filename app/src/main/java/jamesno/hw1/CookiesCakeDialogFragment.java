package jamesno.hw1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by James No on 5/4/2017.
 */

public class CookiesCakeDialogFragment extends DialogFragment{

//    public void openDialog() {
//        DialogFragment newFragment = new FireMissilesDialogFragment();
//        newFragment.show(getSupportFragmentManager(), "missiles");
//    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.cookies_cake)
                .setPositiveButton(R.string.cookies, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Have some cookies!
                    }
                })
                .setNegativeButton(R.string.cake, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Have some cake!
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }
}

