package com.example.nikhilg.androidtesting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by nikhilg on 1/9/2017.
 */

public class MyReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context,Intent intent)
    {
        Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();

        Log.d("Context",String.valueOf(context));
        Log.d("Intent",String.valueOf(intent));
    }
}
