package com.example.ampprac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {
TextView tvText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        tvText=findViewById(R.id.tvText);
        Intent fromOtherIntent=getIntent();
       String value= fromOtherIntent.getStringExtra("value");

        tvText.setText(value);
    }

    @Override
    protected void onRestart() {
        Log.d("App","On restart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d("app route","ON DESTROYED");
        super.onDestroy();
    }
}