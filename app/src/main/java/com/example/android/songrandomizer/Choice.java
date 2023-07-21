package com.example.android.songrandomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choice extends AppCompatActivity {

    private Button button,button1,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        button = findViewById(R.id.random);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        button1 = findViewById(R.id.category);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoice2();
            }
        });

        //button1 = findViewById(R.id.individual);
       //button1.setOnClickListener(new View.OnClickListener() {
          //  @Override
          // public void onClick(View v) {
           //    openList();
         //   }
       // });
        button2 = findViewById(R.id.internal);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMusicList();
            }
        });


    }

    public void openMainActivity(){
        Intent intent = new Intent(Choice.this,MainActivity.class);
        startActivity(intent);
    }

   //public void openList(){
      // Intent intent2 = new Intent(Choice.this,List.class);
      //  startActivity(intent2);
   // }


    public void openMusicList(){
        Intent intent3 = new Intent(Choice.this,MusicList.class);
        startActivity(intent3);
    }

    public void openChoice2(){
        Intent intent4 = new Intent(Choice.this,Choice2.class);
        startActivity(intent4);
    }
}