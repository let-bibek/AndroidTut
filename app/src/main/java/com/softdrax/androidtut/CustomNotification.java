package com.softdrax.androidtut;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomNotification extends AppCompatActivity {
    Button btnCusNotify;
    static final String DAILY_FITNESS_QUOTE_ID = "Fitness quote";
    static final int FITNESS_APP_CHANNEL_ID = 2;
    static final int REQUEST_CODE = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_notification);
        btnCusNotify = findViewById(R.id.btnCusNotify);

//        icon
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.icon, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent notifyIntent = new Intent(CustomNotification.this, CustomNotification.class);
        notifyIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(CustomNotification.this, REQUEST_CODE, notifyIntent, FLAG_UPDATE_CURRENT);

//        big picture style

        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.icon, null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Daily fitness quotes")
                .setSummaryText("If you want something you've never had, " +
                        "you must be willing to do something you've never done");


//        inbox style

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("1")
                .addLine("10")
                .addLine("100")
                .addLine("1000")
                .addLine("10000")
                .addLine("100000")
                .addLine("1000000")
                .addLine("10000000")
                .addLine("100000000")
                .setBigContentTitle("Daily fitness quotes")
                .setSummaryText("If you want something you've never had, " +
                        "you must be willing to do something you've never done");


        Notification notification = new Notification.Builder(this)
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.app_icon)
                .setContentText("If you want something you've never had, you must be willing to do something you've never done.")
                .setSubText("Daily fitness quote")
                .setContentIntent(pendingIntent)
                .setStyle(inboxStyle)
                .setStyle(bigPictureStyle)
//                .setAutoCancel(false)
//                .setOngoing(true)
                .setChannelId(DAILY_FITNESS_QUOTE_ID)
                .build();

        notificationManager.createNotificationChannel(new NotificationChannel(DAILY_FITNESS_QUOTE_ID, "Quotes", NotificationManager.IMPORTANCE_DEFAULT));


        btnCusNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.notify(FITNESS_APP_CHANNEL_ID, notification);
            }
        });

    }
}