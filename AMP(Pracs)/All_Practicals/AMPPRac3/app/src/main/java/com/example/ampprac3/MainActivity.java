package com.example.ampprac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    MaterialButton btnNEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNEXT= findViewById(R.id.btnNext);
        btnNEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toNextPage= new Intent(MainActivity.this,Page2.class);
                toNextPage.putExtra("value","Hello from screen 1");
                startActivity(toNextPage);
            }
        });
    }

    @Override
    protected void onPause() {
        Log.d("app route","ON PAUSE");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d("app route","ON RESTART");
        super.onRestart();
    }
}