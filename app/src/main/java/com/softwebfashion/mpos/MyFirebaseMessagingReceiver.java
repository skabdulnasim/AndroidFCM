package com.softwebfashion.mpos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyFirebaseMessagingReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle background notifications here (optional)
        Log.d("ForeGround", "aaaaaaaaaaa");
    }
}
