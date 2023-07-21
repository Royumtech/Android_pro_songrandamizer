package com.example.android.songrandomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    ImageView logo,appName,splashImage;
    LottieAnimationView lottieAnimationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.app);
        appName = findViewById(R.id.text);
        splashImage = findViewById(R.id.image);
        lottieAnimationView = findViewById(R.id.lottie);




        lottieAnimationView.animate().translationY(1000).setDuration(2000).setStartDelay(9000);


        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {

                Intent intent = new Intent(
                        Splash.this, Choice.class);
                startActivity(intent);
            }
            @Override
            public void onAnimationCancel(Animator animator) {
                       
            }
            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

}