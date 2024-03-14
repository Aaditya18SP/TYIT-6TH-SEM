package com.example.tyit_29_prac1.Prac6_7_8_9;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyit_29_prac1.R;

public class ReceiveDataActivity extends AppCompatActivity {
    TextView tvName, tvAge, tvFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        //INITIALIZE THE VIEWS
        tvName = findViewById(R.id.tvPrac6789Name);
        tvAge = findViewById(R.id.tvPrac6789Age);
        tvFriends = findViewById(R.id.tvPrac6789Friends);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();

            String[] friendsArray = bundle.getStringArray("friends");
            String receivedName = bundle.getString("name", "");
            int receivedAge = bundle.getInt("age");


            String friendString = "";
            for (String fr : friendsArray) {
                friendString += fr + ",";
            }

            Log.d("PRAC6789", "Name received is: " + receivedName);
            Log.d("PRAC6789", "Age received is: " + receivedAge);
            Log.d("PRAC6789", "Friends String is: " + friendString);
            tvName.setText(receivedName);
            tvAge.setText(String.valueOf(receivedAge));
            tvFriends.setText(friendString);
        }
    }
}