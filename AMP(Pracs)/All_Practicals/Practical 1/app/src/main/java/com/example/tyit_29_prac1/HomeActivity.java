package com.example.tyit_29_prac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tyit_29_prac1.Prac10.AudioActivity;
import com.example.tyit_29_prac1.Prac10.VideoActivity;
import com.example.tyit_29_prac1.Prac11.NotificationActivity;
import com.example.tyit_29_prac1.Prac3LifeCycle.ActivityAndFragmentsLifeCycle;
import com.example.tyit_29_prac1.Prac6_7_8_9.EnterDataActivity;
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
                else if (itemId == R.id.menuPrac4) {
                    Intent intentToPrac4 = new Intent(HomeActivity.this, Prac4Activity.class);
                    finish();
                    startActivity(intentToPrac4);
                } else if (itemId == R.id.menuPrac3) {
                    Intent toPrac3 = new Intent(HomeActivity.this, ActivityAndFragmentsLifeCycle.class);
                    finish();
                    startActivity(toPrac3);
                } else if (itemId == R.id.menuPrac6789) {
                    Intent toEnterDataActivity = new Intent(HomeActivity.this, EnterDataActivity.class);
                    startActivity(toEnterDataActivity);
                } else if (itemId == R.id.menuPrac10Audio) {
                    Intent toAudioAct = new Intent(HomeActivity.this, AudioActivity.class);
                    startActivity(toAudioAct);
                } else if (itemId == R.id.menuPrac10Video) {
                    Intent toVideoAct = new Intent(HomeActivity.this, VideoActivity.class);
                    startActivity(toVideoAct);
                } else if (itemId == R.id.menuPrac11Notification) {
                    Intent toNotificationActivity = new Intent(HomeActivity.this, NotificationActivity.class);
                    startActivity(toNotificationActivity);
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