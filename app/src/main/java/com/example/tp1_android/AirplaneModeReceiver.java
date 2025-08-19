package com.example.tp1_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean airplaneModeActivated = intent.getBooleanExtra("state",false);
        if (airplaneModeActivated){
            Toast.makeText(context, "Modo avion activado", Toast.LENGTH_SHORT).show();

            String phoneNumber = "1234567890";
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:" + phoneNumber));
            dialIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(dialIntent);

        }else{
            Toast.makeText(context, "Modo avion desactivado", Toast.LENGTH_SHORT).show();
        }
    }
}