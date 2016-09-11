package com.example.praveenax.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * Created by Praveenax on 9/11/2016.
 */
class CustomAdapter extends ArrayAdapter<String>  {

    public CustomAdapter(Context context, String[] resource) {
        super(context,R.layout.custom_list_item ,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater cusInflater = LayoutInflater.from(getContext());
        View cusView = cusInflater.inflate(R.layout.custom_list_item,parent,false);

        String txt = getItem(position);
        TextView cText = (TextView) cusView.findViewById(R.id.textView);

        cText.setText(txt);


        return cusView;


//        return super.getView(position, convertView, parent);
    }
}
