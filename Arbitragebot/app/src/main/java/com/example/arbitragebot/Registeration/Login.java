package com.example.arbitragebot.Registeration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arbitragebot.MainActivity;
import com.example.arbitragebot.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {

    Button callSignUp, loginbtn,callForgot;
    ImageView image;
    TextView logoText, logodesc;
    TextInputLayout Username, Password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        //Hooks
        image = findViewById(R.id.logoimg);
        logoText = findViewById(R.id.logo_name);
        logodesc = findViewById(R.id.logodesc);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.login);






        callSignUp = findViewById(R.id.signup);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Signup.class);

                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(image, "logo image");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                pairs[2] = new Pair<View, String>(logodesc, "logo_desc");
                pairs[3] = new Pair<View, String>(Username, "user_tran");
                pairs[4] = new Pair<View, String>(Password, "pass_tran");
                pairs[5] = new Pair<View, String>(loginbtn, "button_tran");
                pairs[6] = new Pair<View, String>(callSignUp, "signup_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                startActivity(intent, options.toBundle());





            }


        });

        callForgot = findViewById(R.id.forgot);
        callForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,ForgetPassword.class);
                startActivity(intent);
            }
        });

    }

    private Boolean validateUsername() {
        String val = Username.getEditText().getText().toString();


        if (val.isEmpty()) {
            Username.setError("Field cannot be empty");
            return false;

        } else {
            Username.setError(null);
            Username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = Password.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{6,}" +               //at least 6 characters
                "$";
        if (val.isEmpty()) {
            Password.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            Password.setError("Wrong Password");
            return false;
        } else {
            Password.setError(null);
            Password.setErrorEnabled(false);
            return true;
        }
    }



    public void logThemIn(View view) {
        if (!validateUsername() | !validatePassword()) {
            return;
        } else {

            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
    }




   /* private void isUser() {
        progressBar.setVisibility(View.VISIBLE);
        final String userEnteredUsername = Username.getEditText().getText().toString().trim();
        final String userEnteredPassword = Password.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Username.setError(null);
                    Username.setErrorEnabled(false);
                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)) {
                        Username.setError(null);
                        Username.setErrorEnabled(false);
                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phoneNo", phoneNoFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    } else {
                        progressBar.setVisibility(View.GONE);
                        Password.setError("Wrong Password");
                        Password.requestFocus();
                    }
                } else {
                    progressBar.setVisibility(View.GONE);
                    Username.setError("No such User exist");
                    Username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/
}