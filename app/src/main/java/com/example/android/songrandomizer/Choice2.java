package com.example.android.songrandomizer;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Choice2 extends AppCompatActivity {

    private Button button, button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice2);

        button = findViewById(R.id.mood);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMoodBoosters();
            }
        });

        button1 = findViewById(R.id.workout);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             openWorkout();
            }
        });

        button2 = findViewById(R.id.Study);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           openStudy();
            }
        });

        button3 = findViewById(R.id.Indian);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          openIndian();
            }
        });

        button4 = findViewById(R.id.western);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWestern();
            }
        });
    }

    public void openMoodBoosters(){
        Intent intent5 = new Intent(Choice2.this,MoodBoosters.class);
        startActivity(intent5);
    }

    public void openWestern(){
        Intent intent6 = new Intent(Choice2.this,Western.class);
        startActivity(intent6);
    }

    public void openWorkout(){
        Intent intent7 = new Intent(Choice2.this,Workout.class);
        startActivity(intent7);
    }

    public void openStudy(){
        Intent intent8 = new Intent(Choice2.this,Study.class);
        startActivity(intent8);
    }
    public void openIndian(){
        Intent intent9 = new Intent(Choice2.this,Indian.class);
        startActivity(intent9);
    }


}
