package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationClass extends AppCompatActivity {
    Button btnNotify;
    static final String FITNESS_CHANNEL_ID = "fitness reminder channel";
    static final int REMINDER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getSupportActionBar().setTitle("Notification");
        btnNotify = findViewById(R.id.btnNotify);
//        icon
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.icon, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

//        notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.icon)
                    .setContentText("20 minutes workout left for today")
                    .setSubText("Workout Reminder")
                    .setChannelId(FITNESS_CHANNEL_ID)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(FITNESS_CHANNEL_ID, "Reminder", NotificationManager.IMPORTANCE_DEFAULT));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.icon)
                    .setContentText("Workout Reminder")
                    .setSubText("You need to 20 minutes workout today")
                    .build();
        }


        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.notify(REMINDER_ID, notification);
            }
        });

    }
}