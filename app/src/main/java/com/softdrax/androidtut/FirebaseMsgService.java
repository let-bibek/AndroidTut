package com.softdrax.androidtut;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMsgService extends FirebaseMessagingService {
    static final String NOTIFICATION_CHANNEL_ID = "push notification";
    static final int PUSH_NOTIFICATION_ID = 8;

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("New token", token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        if (message.getNotification() != null) {
            pushNotification(
                    message.getNotification().getTitle(),
                    message.getNotification().getBody()
            );
        }
    }

    private void pushNotification(String title, String msg) {

        Notification notification;
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent iNotification = new Intent(FirebaseMsgService.this, MainActivity.class);
        iNotification.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(FirebaseMsgService.this, 100, iNotification, PendingIntent.FLAG_UPDATE_CURRENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            CharSequence name = "Message Channel";
            String description = "Channel for push notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            if (nm != null) {
                nm.createNotificationChannel(notificationChannel);
            }

            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.app_icon)
                    .setContentText(msg)
                    .setSubText(title)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .build();
        } else {
            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.app_icon)
                    .setContentText(msg)
                    .setSubText(title)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();

        }

        if (nm != null) {
            nm.notify(1, notification);
        }


    }
}
