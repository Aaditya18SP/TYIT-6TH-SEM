package com.example.tyit_29_prac1;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
toolbar=findViewById(R.id.tbMain);
setSupportActionBar(toolbar);
        drawerLayout= findViewById(R.id.dlHomeActivity);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout, R.string.nav_open,R.string.nav_close);
   drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
   getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}