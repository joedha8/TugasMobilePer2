package com.gmail.yudhapratama539.belajarlayout.Pertemuan7;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gmail.yudhapratama539.belajarlayout.R;

/**
 * Created by joedhaalzelvin on 18/04/18.
 */

public class PlayAudio extends Service{
    MediaPlayer objPlayer;

    public void onCreate(){
        super.onCreate();
        objPlayer=MediaPlayer.create(this, R.raw.twinkle);
    }

    @SuppressLint("WrongConstant")
    public int onStartCommand(Intent intent, int flags, int startId){
        objPlayer.start();
        return 1;
    }

    public void onStop(){
        objPlayer.stop();
        objPlayer.release();
    }

    public void onPause(){
        objPlayer.stop();
        objPlayer.release();
    }

    public void onDestroy(){
        objPlayer.stop();
        objPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
