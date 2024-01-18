package com.example.batterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.content.IntentFilter;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    ProgressBar prg;
    BatteryReceiver BR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        prg = findViewById(R.id.progressBar);
    }

    public void checkBatteryPercentage(View v) {
        BR = new BatteryReceiver(tv,prg);
        registerReceiver(BR,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(BR);
    }


}