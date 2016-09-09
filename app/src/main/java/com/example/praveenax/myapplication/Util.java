package com.example.praveenax.myapplication;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Praveenax on 9/9/2016.
 */
public class Util {

    public static void showAlert(String message,Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("Result");

        // set dialog message
        alertDialogBuilder.setMessage(message);

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public static void showHelp(String title,String message,Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder.setMessage(message);

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
