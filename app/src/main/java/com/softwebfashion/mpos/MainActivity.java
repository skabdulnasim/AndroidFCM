package com.softwebfashion.mpos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subscribeToProductFCMTopic();
        subscribeOrderToFCMTopic();
        subscribeGrnToFCMTopic();
        subscribeCustomerToFCMTopic();
    }

    private void subscribeToProductFCMTopic() {
        String topicName = "threadworks-product";

        FirebaseMessaging.getInstance().subscribeToTopic(topicName)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Subscribed to FCM topic: " + topicName);
                    } else {
                        Log.e(TAG, "Failed to subscribe to FCM topic: " + topicName, task.getException());
                    }
                });
    }
    private void subscribeOrderToFCMTopic() {
        String topicName = "threadworks-1-order";

        FirebaseMessaging.getInstance().subscribeToTopic(topicName)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Subscribed to FCM topic: " + topicName);
                    } else {
                        Log.e(TAG, "Failed to subscribe to FCM topic: " + topicName, task.getException());
                    }
                });
    }
    private void subscribeGrnToFCMTopic() {
        String topicName = "threadworks-1-grn";

        FirebaseMessaging.getInstance().subscribeToTopic(topicName)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Subscribed to FCM topic: " + topicName);
                    } else {
                        Log.e(TAG, "Failed to subscribe to FCM topic: " + topicName, task.getException());
                    }
                });
    }

    private void subscribeCustomerToFCMTopic() {
        String topicName = "threadworks-customer";

        FirebaseMessaging.getInstance().subscribeToTopic(topicName)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Subscribed to FCM topic: " + topicName);
                    } else {
                        Log.e(TAG, "Failed to subscribe to FCM topic: " + topicName, task.getException());
                    }
                });
    }
}