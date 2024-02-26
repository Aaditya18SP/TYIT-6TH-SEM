package com.example.tyit_29_prac1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    MaterialToolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
toolbar=findViewById(R.id.mtbMain);
navigationView=findViewById(R.id.navView);
        drawerLayout= findViewById(R.id.dlHomeActivity);
setSupportActionBar(toolbar);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.nav_open,R.string.nav_close);
   drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
   getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks here
                int itemId = item.getItemId();

                if (itemId == R.id.menuCalc) {
                    // Close the drawer when item is selected
                    Toast.makeText(HomeActivity.this, "CALC clicked", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(HomeActivity.this, CalculatorActivity.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }



        });
        //getOnBackPressedDispatcher().onBackPressed();

        }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}