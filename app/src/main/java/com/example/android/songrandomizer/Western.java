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

public class Western extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_western);


        final ArrayList<word> songs = new ArrayList<word>();

        songs.add(new word(" ", "I Lived - One Republic", R.drawable.musicicon, R.raw.ilived));
        songs.add(new word(" ", "Believer - Imagine Dragons", R.drawable.musicicon, R.raw.believer));
        songs.add(new word(" ", "Paradise - Alan Walker", R.drawable.musicicon, R.raw.paradise));
        songs.add(new word(" ", "Someday", R.drawable.musicicon, R.raw.someday));
        songs.add(new word(" ", "J Balvin Willy William Mi Gente", R.drawable.musicicon, R.raw.yeyeyeye));
        songs.add(new word(" ", "Way Back home", R.drawable.musicicon, R.raw.waybackhome));
        songs.add(new word(" ", "BTS Butter", R.drawable.musicicon, R.raw.btsbutter));
        songs.add(new word(" ", "ROSÉ - On The Ground", R.drawable.musicicon, R.raw.rose));
        songs.add(new word(" ", "The nights - Avicii", R.drawable.musicicon, R.raw.onceiwasachild));
        songs.add(new word(" ", "MaggieLindemannPrettyGirl", R.drawable.musicicon, R.raw.maggielindmann));





        wordAdapter adapter =
                new wordAdapter(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = songs.get(position);
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(Western.this, w.getmAudioresourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(Western.this, "Play Next !", Toast.LENGTH_SHORT).show();
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
