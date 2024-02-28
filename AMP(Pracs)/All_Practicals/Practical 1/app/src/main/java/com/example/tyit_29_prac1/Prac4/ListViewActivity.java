package com.example.tyit_29_prac1.Prac4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tyit_29_prac1.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
ListView lv;
ArrayList<String> carsList= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv=findViewById(R.id.lvCars);





    }
}