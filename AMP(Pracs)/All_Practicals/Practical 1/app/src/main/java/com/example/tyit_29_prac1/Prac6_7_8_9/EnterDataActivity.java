package com.example.tyit_29_prac1.Prac6_7_8_9;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.tyit_29_prac1.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EnterDataActivity extends AppCompatActivity {

    TextInputLayout tilName, tilAge, tilFriends;

    TextInputEditText tietName, tietAge, tietFriends;

    MaterialButton mbtnSubmit;

    Toolbar mtbPrac6789;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);

        //INITIALIZE THE VIEWS

        //toolbar
        mtbPrac6789 = findViewById(R.id.mtbPrac6789);
        setSupportActionBar(mtbPrac6789);

        //TILS
        tilName = findViewById(R.id.tilName);
        tilAge = findViewById(R.id.tilAge);
        tilFriends = findViewById(R.id.tilFriends);

        //TIETS
        tietName = findViewById(R.id.tietName);
        tietAge = findViewById(R.id.tietAge);
        tietFriends = findViewById(R.id.tietFriends);

        //BUTTON
        mbtnSubmit = findViewById(R.id.mbtnSubmit);

        //////////////////////////DOESNT WORK /////////////////////////////////////////////////////////
//
//        //INFLATE THE MENU
//        mtbPrac6789.inflateMenu(R.menu.menu_prac6789);
//
//        //MENU ITEMS ON CLICK LISTENER
//        mtbPrac6789.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int itemId = item.getItemId();
//                if (itemId == R.id.menu_prac6789_info) {
//                    Toast.makeText(EnterDataActivity.this, "INFO ITEM CLICKED", Toast.LENGTH_SHORT).show();
//                } else if (itemId == R.id.menu_prac6789_contact) {
//                    Toast.makeText(EnterDataActivity.this, "CONTACT CLICKED", Toast.LENGTH_SHORT).show();
//                } else if (itemId == R.id.menu_prac6789_email) {
//                    Toast.makeText(EnterDataActivity.this, "EMAIL CLICKED", Toast.LENGTH_SHORT).show();
//                } else if (itemId == R.id.menu_prac6789_help) {
//                    Toast.makeText(EnterDataActivity.this, "HELP CLICKED", Toast.LENGTH_SHORT).show();
//                }
//
//                return true;
//            }
//        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //EVENT LISTENERS

        //1.on click
        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get the data from edit texts
                String name = "";
                String[] friends = new String[0];
                int age = 0;

                if (tietName.getText() != null) {
                    if (!tietName.getText().toString().trim().isEmpty()) {
                        name = tietName.getText().toString().trim();
                    }
                }

                if (tietAge.getText() != null) {
                    if (!tietAge.getText().toString().trim().isEmpty()) {
                        age = Integer.valueOf(tietAge.getText().toString().trim());
                    }
                }

                if (tietFriends.getText() != null) {
                    if (!tietFriends.getText().toString().trim().isEmpty()) {
                        friends = tietFriends.getText().toString().trim().split(",");
                    }
                }

                if (!name.isEmpty() && friends.length > 0 && age > 0) {
                    Log.d("PRAC6789", "Array length is: " + friends.length);
                    Log.d("PRAC6789", "Array is:" + friends.toString());
                    Log.d("PRAC6789", "Name is: " + name);
                    Log.d("PRAC6789", "age is: " + age);
                    Intent toReceiveActivity = new Intent(EnterDataActivity.this, ReceiveDataActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putInt("age", age);
                    bundle.putStringArray("friends", friends);
                    toReceiveActivity.putExtras(bundle);
                    startActivity(toReceiveActivity);

                } else {
                    Toast.makeText(EnterDataActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //2. on touch click
        mbtnSubmit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("PRAC6789", "Touch event listener, action down. X:" + x + " Y :" + y);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("PRAC6789", "Touch event listener, action up. X:" + x + " Y :" + y);
                        break;
                    case MotionEvent.ACTION_BUTTON_PRESS:
                        Log.d("PRAC6789", "Touch event listener, action BUTTON PRESS down. X:" + x + " Y :" + y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("PRAC6789", "Touch event listener, action move . X:" + x + " Y :" + y);
                        break;
                    default:
                        Log.d("PRAC6789", "Touch event listener, NO ACTION IN DEFAULT . X:" + x + " Y :" + y);
                }
                return false;
            }
        });


        //3. oN LONG PRESS
        mbtnSubmit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(EnterDataActivity.this).setTitle("Chod de bhai!").setMessage("LONG PRESS LISTENER EVENT.").setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();

                //display the dialog
                alertDialog.show();
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_prac6789, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_prac6789_info) {
            Toast.makeText(EnterDataActivity.this, "INFO ITEM CLICKED", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu_prac6789_contact) {
            Toast.makeText(EnterDataActivity.this, "CONTACT CLICKED", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu_prac6789_email) {
            Toast.makeText(EnterDataActivity.this, "EMAIL CLICKED", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu_prac6789_help) {
            Toast.makeText(EnterDataActivity.this, "HELP CLICKED", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}