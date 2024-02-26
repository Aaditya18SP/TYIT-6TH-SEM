package com.example.tyit_29_prac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.tyit_29_prac1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        /*----------------
       VARIABLES
         -------------------*/
        MaterialButton mbtnNext= findViewById(R.id.mbtnNext);


        /*----------------
       LISTENERS
         -------------------*/

        //1. Next button's listener
        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCalculatorActivity= new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(toCalculatorActivity);
            }
        });






    }


}