package com.example.praveenax.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    // Array of strings...
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button new_note = (Button)findViewById(R.id.button);
        new_note.setOnClickListener(this);


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.act_listview, mobileArray);

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
                "Button is clicked "+mobileArray[position], Toast.LENGTH_SHORT).show();

        Util.showHelp("Objective: To turn off all the Lights with the least number of moves \n" +
                "\n" +
                "Each switch is inter-connected with other lights in a perpendicular fashion",this);



    }

    @Override
    public void onClick(View view) {
        Util.showHelp("TEST NOTE \n" +
                "\n" +
                "Each switch is inter-connected with other lights in a perpendicular fashion",this);

    }
}
