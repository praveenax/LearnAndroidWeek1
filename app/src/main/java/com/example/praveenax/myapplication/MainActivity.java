package com.example.praveenax.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.EditText;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    // Array of strings...
    String[] mobileArray = {"Android", "IPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X"};

    private EditText result;
    ArrayList<String> mobArray;
    ArrayAdapter adapter;
    DB snappydb;

//    final Context context = this;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            snappydb = DBFactory.open(this); //create or open an existing databse using the default name

            mobArray = new ArrayList<String>();

            String name = snappydb.get("name");
            int age = snappydb.getInt("age");
            boolean single = snappydb.getBoolean("single");
            String[] books = snappydb.getArray("task_items", String.class);// get array of string

//            ArrayList<String> aListNumbers
            if (books.length == 0) {
                mobArray = new ArrayList<String>();
            } else {
                mobArray = new ArrayList<String>(Arrays.asList(books));
            }


//            Util.showHelp("TEST!",""+books[0] +" is Selected",this);

//            adapter = new ArrayAdapter<String>(this, R.layout.act_listview, mobArray);
            adapter = new CustomAdapter(this,books);
//            adapter = new ArrayAdapter<String>(this, R.layout.act_listview, mobArray);
// REFER - https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView


            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setOnItemClickListener(this);
            listView.setAdapter(adapter);

            snappydb.close();

            Button new_note = (Button) findViewById(R.id.button);
            new_note.setOnClickListener(this);

            // Spinner element

            Spinner spinner = (Spinner) findViewById(R.id.spinner);

            // Spinner click listener
            spinner.setOnItemSelectedListener(this);

            // Spinner Drop down elements
            List<String> categories = new ArrayList<String>();
            categories.add("All");
            categories.add("Open");
            categories.add("Closed");

            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinner.setAdapter(dataAdapter);


        } catch (SnappydbException e) {

            Log.e("test", e.toString());
        }


    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1,
                            int position, long id) {

        Util.showHelp("OS Name!", "" + mobArray.get(position) + " is Selected", this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(View view) {
//        Util.showHelp("Add New Note","TEST NOTE",this);

        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
//                                result.setText(userInput.getText());

//                                mobArray.add(""+userInput.getText());

                                try {
                                    snappydb = DBFactory.open(context); //create or open an existing databse using the default name

//                                    Log.v("test",""+mobArray.get(mobArray.size()-1));
                                    mobArray.add("" + userInput.getText());
//                                    Log.v("test2",""+mobArray.get(mobArray.size()-1));

                                    String[] frnames2 = mobArray.toArray(new String[mobArray.size()]);
                                    snappydb.put("task_items", frnames2);

                                    String[] testArr = snappydb.getArray("task_items", String.class);// get array of string

                                    Util.showHelp("OS Name!", "" + testArr[testArr.length - 1] + " is Selected", context);


                                    snappydb.close();

                                } catch (SnappydbException e) {
                                }


                                adapter.notifyDataSetChanged();

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
}
