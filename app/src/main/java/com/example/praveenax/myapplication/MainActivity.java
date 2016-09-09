package com.example.praveenax.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    // Array of strings...
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};

    private EditText result;
    ArrayList<String> mobArray;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button new_note = (Button)findViewById(R.id.button);
        new_note.setOnClickListener(this);

        mobArray = new ArrayList<String>();
        mobArray.add("Android");
        mobArray.add("IPhone");
        mobArray.add("WindowsMobile");
        mobArray.add("Blackberry");
        mobArray.add("WebOS");
        mobArray.add("Ubuntu");
        mobArray.add("Windows7");
        mobArray.add("Max OS X");

        adapter = new ArrayAdapter<String>(this, R.layout.act_listview, mobArray);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1,
                            int position, long id) {

//        Intent in1 = new Intent(Activites_Activity.this, Activity_display.class);
//
//        startActivity(in1);

        Toast.makeText(getApplicationContext(),
//                "Button is clicked "+mobileArray[position], Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),
                "Button is clicked "+mobArray.get(position) , Toast.LENGTH_SHORT).show();

//        Util.showHelp("OS Name!",""+mobileArray[position]+" is Selected",this);
        Util.showHelp("OS Name!",""+mobArray.get(position)+" is Selected",this);



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
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
//                                result.setText(userInput.getText());

                                mobArray.add(""+userInput.getText());

                                adapter.notifyDataSetChanged();

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
}
