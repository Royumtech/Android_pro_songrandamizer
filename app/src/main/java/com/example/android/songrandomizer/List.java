package com.example.android.songrandomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class List extends AppCompatActivity{

    private MediaPlayer mMediaPlayer;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        final ArrayList<word> songs = new ArrayList<word>();

        //songs.add(new word("3-idiots", "All Is Well", R.drawable.idiots, R.raw.alliswell));
        //songs.add(new word("American rock", "Believer", R.drawable.believer, R.raw.believer));
        //songs.add(new word("Chak De India", "Chak de India", R.drawable.chkdeindia, R.raw.chakdeindia));
        //songs.add(new word("Ae Dil H Muskil", "Channa Mere Yaa", R.drawable.chanamereyaa, R.raw.channamereyaa));
        //songs.add(new word("Ramleela", "NAgade Sang Dhol Baje", R.drawable.nagada, R.raw.dholbaaje));
        //songs.add(new word("BTS", "Dynamite", R.drawable.dynamite, R.raw.dynamite));
        //songs.add(new word("Album", "Hwa Banke", R.drawable.hwabanke, R.raw.hwabanke));
        //songs.add(new word("Bahubali", "Jay Jay Kara", R.drawable.jayjaykara, R.raw.jayjaykara));
        ///songs.add(new word("Neerja", "Jeete H Chl", R.drawable.neerja, R.raw.jeetehchl));
        //songs.add(new word("Jabariya Jodi", "Khadke Glassy", R.drawable.glassy, R.raw.khadkeglassy));
        //songs.add(new word("Bahubali 2", "Kya Kbhi Amber Se", R.drawable.kyakbhiamberse, R.raw.kyakbhiamberse));
        //songs.add(new word("Malang", "Malang", R.drawable.malang, R.raw.malang));
        //songs.add(new word("Lies My Father Told Me", "My Father Told me Once i", R.drawable.fathertold, R.raw.onceiwasachild));
        //songs.add(new word("Shershah", "Ranjha", R.drawable.ranjha, R.raw.ranjha));
        //songs.add(new word("Sonu ke titu ki Shadi", "Tera Yaar Hoon Mai", R.drawable.yaarhoon, R.raw.terayaarhumai));




        wordAdapter adapter =
                new wordAdapter(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = songs.get(position);
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(List.this, w.getmAudioresourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(List.this,"Play Next !",Toast.LENGTH_SHORT).show();
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

