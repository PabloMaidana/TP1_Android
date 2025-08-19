package com.example.tp1_android;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AirplaneModeReceiver airplaneEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        airplaneEvent = new AirplaneModeReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(airplaneEvent, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneEvent);
    }
}