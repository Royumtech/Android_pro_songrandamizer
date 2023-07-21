package com.example.android.songrandomizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;
import java.util.Random;

import static android.widget.Toast.*;

public class MainActivity
        extends AppCompatActivity  {

    // Instantiating the MediaPlayer class
    MediaPlayer[] music = new MediaPlayer[45];
    int n;

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Adding the music file to our
        // newly created object music
        music[0] = MediaPlayer.create(MainActivity.this,R.raw.alliswell);
        music[1] = MediaPlayer.create(MainActivity.this,R.raw.buddhu);
        music[2] = MediaPlayer.create(MainActivity.this,R.raw.ranjha);
        music[3] = MediaPlayer.create(MainActivity.this,R.raw.pacification);
        music[4] = MediaPlayer.create(MainActivity.this,R.raw.paradise);
        music[5] = MediaPlayer.create(MainActivity.this,R.raw.ptd);
        music[6] = MediaPlayer.create(MainActivity.this,R.raw.desi);
        music[7] = MediaPlayer.create(MainActivity.this,R.raw.onceiwasachild);
        music[8] = MediaPlayer.create(MainActivity.this,R.raw.jeetehchl);
        music[9] = MediaPlayer.create(MainActivity.this,R.raw.dive);
        music[10] = MediaPlayer.create(MainActivity.this,R.raw.forest);
        music[11] = MediaPlayer.create(MainActivity.this,R.raw.yaarondosti);
        music[12] = MediaPlayer.create(MainActivity.this,R.raw.dholbaaje);
        music[13] = MediaPlayer.create(MainActivity.this,R.raw.malang);
        music[14] = MediaPlayer.create(MainActivity.this,R.raw.chaarkadam);
        music[15] = MediaPlayer.create(MainActivity.this,R.raw.iktara);
        music[16] = MediaPlayer.create(MainActivity.this,R.raw.ilived);
        music[17] = MediaPlayer.create(MainActivity.this,R.raw.hauli);
        music[18] = MediaPlayer.create(MainActivity.this,R.raw.imagine);
        music[19] = MediaPlayer.create(MainActivity.this,R.raw.inspireflight);
        music[20] = MediaPlayer.create(MainActivity.this,R.raw.jeetritviz);
        music[21] = MediaPlayer.create(MainActivity.this,R.raw.kunfayakun);
        music[22] = MediaPlayer.create(MainActivity.this,R.raw.maggielindmann);
        music[23] = MediaPlayer.create(MainActivity.this,R.raw.maintaiyaar);
        music[24] = MediaPlayer.create(MainActivity.this,R.raw.rise);
        music[25] = MediaPlayer.create(MainActivity.this,R.raw.rose);
        music[26] = MediaPlayer.create(MainActivity.this,R.raw.saibo);
        music[27] = MediaPlayer.create(MainActivity.this,R.raw.srilankan);
        music[28] = MediaPlayer.create(MainActivity.this,R.raw.yeyeyeye);
        music[29] = MediaPlayer.create(MainActivity.this,R.raw.youngblood);
        music[30] = MediaPlayer.create(MainActivity.this,R.raw.zinda);
        music[31] = MediaPlayer.create(MainActivity.this,R.raw.winter);
        music[32] = MediaPlayer.create(MainActivity.this,R.raw.waybackhome);
        music[33] = MediaPlayer.create(MainActivity.this,R.raw.soothing);
        music[34] = MediaPlayer.create(MainActivity.this,R.raw.someday);
        music[35] = MediaPlayer.create(MainActivity.this,R.raw.champion);
        music[36] = MediaPlayer.create(MainActivity.this,R.raw.allahwariyan);
        music[37] = MediaPlayer.create(MainActivity.this,R.raw.besabriyan);
        music[38] = MediaPlayer.create(MainActivity.this,R.raw.thugle);
        music[39] = MediaPlayer.create(MainActivity.this,R.raw.brotheranthum);
        music[34] = MediaPlayer.create(MainActivity.this,R.raw.centuries);
        music[41] = MediaPlayer.create(MainActivity.this,R.raw.upbeat);
        music[42] = MediaPlayer.create(MainActivity.this,R.raw.blessing);
        music[43] = MediaPlayer.create(MainActivity.this,R.raw.champion);
        music[44] = MediaPlayer.create(MainActivity.this,R.raw.champion);


    }

    // Playing the music

    public void musicplay(View v)
    {

        for(int i = 0 ; i < 1 ; i++) {
            Random r = new Random();
            n = r.nextInt(15);


            music[n].start();

        }

        Toast.makeText(MainActivity.this ,"playing" + n,Toast. LENGTH_SHORT).show();

        }






    // Pausing the music
    public void musicpause(View v)
    {
        music[n].pause();
        Toast.makeText(MainActivity.this ,"paused" + n,Toast. LENGTH_SHORT).show();
    }

    // Stoping the music
    public void musicstop(View v)
    {
        music[n].stop();
        Toast.makeText(MainActivity.this ,"stopped" + n,Toast. LENGTH_SHORT).show();
    }

    public void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }


    public void releaseMediaPlayer(){
        if(music[n] != null){
            music[n].release();
            music[n] = null;
        }

    }


}