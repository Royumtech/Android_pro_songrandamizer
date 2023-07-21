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

public class MoodBoosters extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);


        final ArrayList<word> songs = new ArrayList<word>();

        songs.add(new word(" ", "Saibo", R.drawable.saibo, R.raw.saibo));
        songs.add(new word(" ", "Char Kadam", R.drawable.charkadam, R.raw.chaarkadam));
        songs.add(new word(" ", "Manike Mage Hite", R.drawable.manikemagehite, R.raw.srilankan));
        songs.add(new word(" ", "Give Me Some SunShine", R.drawable.sunshine, R.raw.sunshine));
        songs.add(new word(" ", "Jeete H Chal", R.drawable.jeetehchl, R.raw.jeetehchl));
        songs.add(new word(" ", "All Is Well", R.drawable.alliswell, R.raw.alliswell));
        songs.add(new word(" ", "Jeet Ritwiz", R.drawable.jeetritviz, R.raw.jeetritviz));
        songs.add(new word(" ", "Permission To Dance", R.drawable.permitodance, R.raw.ptd));

        songs.add(new word(" ", "Ranjha", R.drawable.ranjha, R.raw.ranjha));
        songs.add(new word(" ", "Malang", R.drawable.malang, R.raw.malang));







        wordAdapter adapter =
                new wordAdapter(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = songs.get(position);
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(MoodBoosters.this, w.getmAudioresourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MoodBoosters.this,"Play Next !",Toast.LENGTH_SHORT).show();
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
