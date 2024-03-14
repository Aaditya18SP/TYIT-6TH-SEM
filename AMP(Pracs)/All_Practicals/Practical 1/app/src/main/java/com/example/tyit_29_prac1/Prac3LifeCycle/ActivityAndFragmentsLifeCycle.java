package com.example.tyit_29_prac1.Prac3LifeCycle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tyit_29_prac1.R;
import com.google.android.material.button.MaterialButton;

public class ActivityAndFragmentsLifeCycle extends AppCompatActivity {
    MaterialButton mbtnToggleFragments, mbtnPrac3ToPrac4, mbtnShowDialog;
    int selectedFrag = 1;
    AlertDialog alertDialog;

    //FragmentContainer fragmentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_and_fragments_life_cycle);

        mbtnPrac3ToPrac4 = findViewById(R.id.mbtnPrac3ToPrac4);
        mbtnToggleFragments = findViewById(R.id.mbtnToggleFragments);
        mbtnShowDialog = findViewById(R.id.mbtnShowDialog);

        Log.d("PRAC3_ACT_LIFECYCLE", "I am in OnCreate(), as i have been placed in memory");


        mbtnToggleFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFragment(selectedFrag);
                selectedFrag++;
                //transaction.commitNow();
            }
        });

        //CREATE A ALERT DIALOG BOX
        alertDialog = new AlertDialog.Builder(this).setTitle("Helllooo, I am in foreground now").setCancelable(false).setIcon(R.drawable.ic_launcher_foreground).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("PRAC3_Dialog", "Yes clicked");
            }
        }).setNegativeButton("Dimiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();

        if (alertDialog != null) {
            Log.d("PRAC3_ACT_LIFECYCLE", "alertDialog is initialized");
        } else {
            Log.d("PRAC3_ACT_LIFECYCLE", "alertDialog is not initialized");
        }

        //Navigate away
        mbtnPrac3ToPrac4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+918007941369"));
                startActivity(intent);
            }
        });

        //SHOW A DIALOG TO ENTER INTO ON PAUSE
        mbtnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
    }

    public void toggleFragment(int selectedFrag) {
        Fragment fr;
        //int currentFrag=selectedFrag;
        Log.d("PRAC3_ToggleFrag", "selectedFrag is:" + selectedFrag);
        if (selectedFrag % 2 == 0) {
            fr = new Fragment2();
            //currentFrag=2;
            Log.d("PRAC3_ToggleFrag", "adding fragment 2");
        } else {
            fr = new Fragment1();
            //transaction.replace(R.id.fragmentHolder1,Fragment1.class, null);
            Log.d("PRAC3_ToggleFrag", "adding frag 1");
            //currentFrag=1;
        }
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentHolder1, fr, null).commit();
        //transaction.commitNow();


    }


    @Override
    protected void onStart() {
        Log.d("PRAC3_ACT_LIFECYCLE", "I am in OnStart(), I am visible to the you but you cant interact with me");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("PRAC3_ACT_LIFECYCLE", "I am in OnResume(), I am visible, in the foregound and you can interact with me now");

        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d("PRAC3_ACT_LIFECYCLE", "I am in OnPause(), as i am partially visible but not in the foreground");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("PRAC3_ACT_LIFECYCLE", "I am in OnStop(), as i am in the background and not visible to you");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d("PRAC3_ACT_LIFECYCLE", "I am in OnRestart(), WOHOOO! I was in background but now i am coming back to the foreground, I am calling onStart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d("PRAC3_ACT_LIFECYCLE", "I am in OnDestroy(), OPPS!! Byee I am being destroyed from the memory");
        super.onDestroy();
    }
}