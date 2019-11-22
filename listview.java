package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class listview extends AppCompatActivity
{
    private Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    final ListView listview = (ListView) findViewById(R.id.listView);
        String[] values = new String[]{
                "Contacts",
                "aimen : 03344239858",
                "hira : 03334567890",
                "lalarukh : 03344567892",
                "Ali : 03345678219",
                "Ahmed : 03344556778" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, android.R.id.text1, values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                String itemVlue = (String) listview.getItemAtPosition(position);
                Toast.makeText(listview.this, itemVlue, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

