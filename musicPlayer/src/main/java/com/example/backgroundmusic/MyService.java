package com.example.backgroundmusic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MyService extends Service {
    public MyService() {
    }


    MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }


    public int onStartCommand(Intent intent,int flags,int startId) {
        String ok = "sleepwalker";
        mp = MediaPlayer.create(this,R.raw.);
        mp.setLooping(true);
        mp.start();
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}