package com.example.arbitragebot.Registeration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.arbitragebot.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    TextInputLayout Name, Username, Email, PhoneNo, Password;
    Button Register, ToLoginBtn;
    ImageView GoBack;

    //Firebase
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);




        //Hooks to all xml elements in activity_sign_up.xml
        Name = findViewById(R.id.fullname);
        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        PhoneNo = findViewById(R.id.phoneNo);
        Password = findViewById(R.id.password);
        Register = findViewById(R.id.signup_next_button);
        ToLoginBtn = findViewById(R.id.signup_login_button);

        ToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });
    }




    //Validating all the fields
    private Boolean validateName() {
        String val = Name.getEditText().getText().toString();

        if (val.isEmpty()) {
            Name.setError("Field cannot be empty");
            return false;
        } else {
            Name.setError(null);
            Name.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = Username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,15}\\z";

        if (val.isEmpty()) {
            Username.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            Username.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            Username.setError("Only Alphabets,4-15,No Spaces Allowed");
            return false;
        } else {
            Username.setError(null);
            Username.setErrorEnabled(false);
            return true;
        }
    }


    private Boolean validateEmail() {
        String val = Email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            Email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            Email.setError("Invalid email address");
            return false;
        } else {
            Email.setError(null);
            Email.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNo() {
        String val = PhoneNo.getEditText().getText().toString();
        if (val.isEmpty()) {
            PhoneNo.setError("Field cannot be empty");
            return false;
        } else {
            PhoneNo.setError(null);
            PhoneNo.setErrorEnabled(false);
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
            Password.setError("Password can only have  digit,alphabet,@#$%^&+=,no spaces and 6 characters");
            return false;
        } else {
            Password.setError(null);
            Password.setErrorEnabled(false);
            return true;
        }
    }


    //Register user on clicking register button
    public void RegisterUser(View v) {

        if (!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername()) {
            return;
        }

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        //Get all the values
        String name = Name.getEditText().getText().toString();
        String username = Username.getEditText().getText().toString();
        String email = Email.getEditText().getText().toString();
        String PHONE = PhoneNo.getEditText().getText().toString();
        String password = Password.getEditText().getText().toString();


        //   Intent intent = new Intent(getApplicationContext(), verifyOTP.class);
        //  intent.putExtra("phoneNo", PHONE);
        //startActivity(intent);


        UserHelperClass helperClass = new UserHelperClass(name, username, email, PHONE, password);
        reference.child(username).setValue(helperClass);

        Toast.makeText(this, "Your Account has been created Successfully!!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();


    }
}