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

public class Indian extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian);


        final ArrayList<word> songs = new ArrayList<word>();

        songs.add(new word(" ", "Buddhu Sa Mann", R.drawable.buddhu, R.raw.buddhu));
        songs.add(new word(" ", "Allah Waariyaan", R.drawable.allahwaariyan, R.raw.allahwariyan));
        songs.add(new word(" ", "Iktara", R.drawable.iktara, R.raw.iktara));
        songs.add(new word(" ", "Kun Faya Kun", R.drawable.kunfaykun, R.raw.kunfayakun));
        songs.add(new word(" ", "Desi Girl", R.drawable.desigirl, R.raw.desi));
        songs.add(new word(" ", "Besabriyaan", R.drawable.besabriyaan, R.raw.besabriyan));
        songs.add(new word(" ", "Yaaron Dosti", R.drawable.yaarondosti, R.raw.yaarondosti));
        songs.add(new word(" ", "Hauli Hauli", R.drawable.haulihauli, R.raw.hauli));
        songs.add(new word(" ", "Thug Le", R.drawable.thagle, R.raw.thugle));
        songs.add(new word(" ", "Nagade Sang Dhol Baje", R.drawable.dhol, R.raw.dholbaaje));





        wordAdapter adapter =
                new wordAdapter(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = songs.get(position);
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(Indian.this, w.getmAudioresourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(Indian.this,"Play Next !",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }


    public void releaseMediaPlayer(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }

    }








}
