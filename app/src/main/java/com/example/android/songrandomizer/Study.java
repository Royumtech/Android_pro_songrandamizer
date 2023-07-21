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

public class Study extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);


        final ArrayList<word> songs = new ArrayList<word>();

        songs.add(new word(" ", "Blessings", R.drawable.musicicon, R.raw.blessing));
        songs.add(new word(" ", "Inspirational Flight", R.drawable.musicicon, R.raw.inspireflight));
        songs.add(new word(" ", "Winter", R.drawable.musicicon, R.raw.winter));
        songs.add(new word(" ", "Upbeat", R.drawable.musicicon, R.raw.upbeat));
        songs.add(new word(" ", "Calming", R.drawable.musicicon, R.raw.calming));
        songs.add(new word(" ", "Forest", R.drawable.musicicon, R.raw.forest));
        songs.add(new word(" ", "Soothing", R.drawable.musicicon, R.raw.soothing));
        songs.add(new word(" ", "Pacification", R.drawable.musicicon, R.raw.pacification));





        wordAdapter adapter =
                new wordAdapter(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = songs.get(position);
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(Study.this, w.getmAudioresourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(Study.this,"Play Next !",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void onStop(){
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
