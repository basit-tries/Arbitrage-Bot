package com.example.arbitragebot;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arbitragebot.Boarding;


public class SplashScreen extends AppCompatActivity {

    private static int Splash_Screen = 3000;

    //anim_variable
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);


        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //animation_hooks
        image = findViewById(R.id.logoimg);
        logo = findViewById(R.id.logo);

        //assigning to images and text

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Boarding.class);
                Pair [] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(image,"logo image");
                pairs[1] = new Pair<View,String>(logo,"logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pairs);

                startActivity(intent,options.toBundle());
                finish();

            }
        },Splash_Screen);
    }
}


