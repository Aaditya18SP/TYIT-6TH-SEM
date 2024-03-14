package com.example.tyit_29_prac1.Prac4;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyit_29_prac1.CustomAdapters.Prac4GridViewAdapter;
import com.example.tyit_29_prac1.R;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    GridView gv;
    ArrayList<String> products = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gv = findViewById(R.id.gvPrac4);

        products.add("Product 1");
        products.add("Book");
        products.add("Linux Mint");
        products.add("Ubuntu");
        products.add("Debian");
        products.add("Fedora");
        products.add("Arch Linux");
        products.add("Manjaro");
        products.add("Laptop");
        products.add("Pendrive");
        products.add("Rufus");
        products.add("Diskpart");

        Prac4GridViewAdapter adapter = new Prac4GridViewAdapter(this, products);
        gv.setAdapter(adapter);


    }
}