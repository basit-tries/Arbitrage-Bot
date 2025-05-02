package com.example.arbitragebot.Registeration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.arbitragebot.Boarding;
import com.example.arbitragebot.MainActivity;
import com.example.arbitragebot.R;
import com.example.arbitragebot.SplashScreen;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Objects;

public class Settings extends AppCompatActivity {
    ImageView pressback, logout;

    private View parentView;
    private SwitchMaterial darkmode;
    private UserSettings settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_settings);





        pressback = findViewById(R.id.backbtn);
        pressback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);


            }
        });


        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this,Boarding.class);
                startActivity(intent);
            }
        });




    }






}
