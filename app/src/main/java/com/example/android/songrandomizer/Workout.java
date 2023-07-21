package com.example.android.songrandomizer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Workout extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);


        final ArrayList<word> songs = new ArrayList<word>();


        songs.add(new word(" ", "Centuries", R.drawable.centuries, R.raw.centuries));
        songs.add(new word(" ", "Youngblood - 5SecondsOfSummer", R.drawable.youngbold, R.raw.youngblood));
        songs.add(new word(" ", "Dive - Hot Shade and Mike Perry", R.drawable.dive, R.raw.dive));
        songs.add(new word(" ", "Rise - League of legends", R.drawable.rise, R.raw.rise));
        songs.add(new word(" ", "Zinda ", R.drawable.zinda, R.raw.zinda));
        songs.add(new word(" ", "Whatever It takes - Imagine Dragons", R.drawable.whateverittakes, R.raw.imagine));
        songs.add(new word(" ", "Revolution - The Score", R.drawable.revolution, R.raw.revolution));
        songs.add(new word(" ", "Champion - Dwayne DJ Bravo ", R.drawable.champion, R.raw.champion));
        songs.add(new word(" ", "Brothers Anthem ", R.drawable.brothersanthem, R.raw.brotheranthum));
        songs.add(new word(" ", "Main Taiyaar Hoon ", R.drawable.mainhoon, R.raw.maintaiyaar));





        wordAdapter adapter =
                new wordAdapter(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = songs.get(position);
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(Workout.this, w.getmAudioresourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(Workout.this, "Play Next !", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }


    }



}
