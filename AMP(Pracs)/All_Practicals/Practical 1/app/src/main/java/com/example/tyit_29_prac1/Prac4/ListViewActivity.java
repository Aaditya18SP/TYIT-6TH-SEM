package com.example.tyit_29_prac1.Prac4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyit_29_prac1.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
ListView lv;
ArrayList<String> carsList= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv = findViewById(R.id.lvCars);

        carsList.add("Porsche GT3");
        carsList.add("Porsche GT3RS");
        carsList.add("Porsche 918 Spyder");
        carsList.add("Porsche Carrera GT");
        carsList.add("Porsche GT2RS");
        carsList.add("Porsche GT4RS");
        carsList.add("Porsche GT4RS Spyder");
        carsList.add("Porsche 911 S/T");
        carsList.add("Porsche 959");
        carsList.add("Porsche 991.2 GT3RS");
        carsList.add("Porsche Carrera RS 2.7");
        carsList.add("Porsche 917");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, carsList);

        lv.setAdapter(adapter);


    }
}