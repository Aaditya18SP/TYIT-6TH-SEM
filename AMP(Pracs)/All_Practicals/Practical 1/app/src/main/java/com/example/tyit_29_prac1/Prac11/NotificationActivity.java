package com.example.tyit_29_prac1.Prac11;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.tyit_29_prac1.R;

public class NotificationActivity extends AppCompatActivity {
    Button btnPrac11SendNotification;
    String CHANNEL_ID = "100";
    int NOTIFICATION_ID = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnPrac11SendNotification = findViewById(R.id.btnPrac11SendNotification);


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "MyNotificationChannel", NotificationManager.IMPORTANCE_DEFAULT);


            manager.createNotificationChannel(notificationChannel);

        }


        btnPrac11SendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_ID)
                        .setAutoCancel(true)
                        .setContentTitle("Notification from Aaditya").setSmallIcon(R.drawable.baseline_beach_access_24).setSubText("This is a subtext").setContentText("This is a context text").build();
                manager.notify(NOTIFICATION_ID, notification);


                if (Settings.System.getInt(getApplicationContext().getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) == 0) {
                    Toast.makeText(getApplicationContext(), "Airplane mode Off", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Airplane mode On", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}