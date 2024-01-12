package com.example.backgroundmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView currentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentState = findViewById(R.id.currentPlayState);

    }

    public void changePlay(View view) {
        if(view == findViewById(R.id.playIcon)) {
            startService(new Intent(this, MyService.class));
            currentState.setText("Playing");
            currentState.setTextColor(Color.GREEN);
        }
        else if(view == findViewById(R.id.pauseIcon)) {
            stopService(new Intent(this, MyService.class));
            currentState.setText("Paused");
            currentState.setTextColor(Color.RED);
        }
    }
}