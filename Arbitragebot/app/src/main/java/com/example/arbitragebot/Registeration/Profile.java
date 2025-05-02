package com.example.arbitragebot.Registeration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arbitragebot.MainActivity;
import com.example.arbitragebot.R;
import com.google.android.material.textfield.TextInputLayout;

public class Profile extends AppCompatActivity {

    TextInputLayout Fullname, Email, PhoneNo, Password;
    TextView fullnameLabel, userNamelabel;
    ImageView prback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_profile);

        Fullname = findViewById(R.id.full_name_profile);
        Email = findViewById(R.id.user_email);
        PhoneNo = findViewById(R.id.user_contact);
        Password = findViewById(R.id.user_pass);
        fullnameLabel = findViewById(R.id.full_name_label);
        userNamelabel = findViewById(R.id.username_label);

        //Show All User Data
       // showAallUserData();


        //back to main from profile
        prback = findViewById(R.id.profback);
        prback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }


  /*  private void showAallUserData() {
        Intent intent = getIntent();
        String user_name = intent.getStringExtra("name");
        String user_username = intent.getStringExtra("username");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phone");
        String user_password = intent.getStringExtra("password");


        fullnameLabel.setText(user_name);
        userNamelabel.setText(user_username);
        Fullname.getEditText().setText(user_name);
        Email.getEditText().setText(user_email);
        PhoneNo.getEditText().setText(user_phoneNo);
        Password.getEditText().setText(user_password);*/


    }

