package com.example.tyit_29_prac1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tyit_29_prac1.Prac4.AbsoluteLayoutActivity;
import com.example.tyit_29_prac1.Prac4.FrameLayoutActivity;
import com.example.tyit_29_prac1.Prac4.LinearLayout;
import com.example.tyit_29_prac1.Prac4.RelativeLayoutActivity;
import com.example.tyit_29_prac1.Prac4.TableLayoutActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class Prac4Activity extends AppCompatActivity {

    MaterialToolbar tbPrac4;
    MaterialButton mbtnLL, mtbnRL,mtbnAL,mtbFL,mtbCL,mbtnTL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prac_4);

        tbPrac4=findViewById(R.id.tbPrac4);
        setSupportActionBar(tbPrac4);
        mbtnLL=findViewById(R.id.mbtnPrac4LinearLayout);
        mtbnRL=findViewById(R.id.mbtnPrac4RelativeLayout);
        mtbnAL=findViewById(R.id.mbtnPrac4AbsoluteLayout);
        mtbFL=findViewById(R.id.mbtnPrac4FrameLayout);
        mtbCL=findViewById(R.id.mbtnPrac4CoordinatorLayout);
        mbtnTL=findViewById(R.id.mbtnPrac4TableLayout);

        mbtnLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Prac4Activity.this, LinearLayout.class);
                startActivity(intent);
            }
        });

        mtbnRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Prac4Activity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        mtbFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Prac4Activity.this, FrameLayoutActivity.class);
                startActivity(intent);
            }
        });
        mtbnAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Prac4Activity.this, AbsoluteLayoutActivity.class);
                startActivity(intent);
            }
        });

        mbtnTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Prac4Activity.this, TableLayoutActivity.class);
                startActivity(intent);
            }
        });

    }
}