package com.softwebfashion.mpos;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "NOTIFICATION";
    private static final String CHANNEL_ID = "default_channel_id"; // Notification Channel ID (Oreo and above)

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "NOTIFICATION: " + remoteMessage.getData().get("type"));
        Log.d("NOTIFICATION:", String.valueOf(remoteMessage));
        if (remoteMessage.getData().size() > 0) {
            // Extract title and body from the data payload
             // String title = remoteMessage.getData().get("type");
            String content = remoteMessage.getData().get("content");
            try {
                String title = remoteMessage.getData().get("title");
                String body = remoteMessage.getData().get("body");
                JSONObject objData = new JSONObject(content);
                sendNotification(title, body);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String title, String body) {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1; // Use a unique ID for each notification

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Create a notification channel (required for Android Oreo and above)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Default Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_foreground) // Replace with your notification icon
                        .setContentTitle(title)
                        .setContentText(body)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
