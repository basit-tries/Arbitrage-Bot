package com.example.arbitragebot.Registeration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.arbitragebot.R;

public class Details extends AppCompatActivity {


    Button store, buttonINC, buttonDEC;
    TextView Counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);


        buttonDEC = findViewById(R.id.decrement);
        buttonINC = findViewById(R.id.increment);
        Counter = findViewById(R.id.counter);



        buttonINC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue = Counter.getText().toString();
                int value = Integer.parseInt(currentValue);
                value++;
                Counter.setText(String.valueOf(value));
            }
        });

        buttonDEC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue = Counter.getText().toString();
                int value = Integer.parseInt(currentValue);
                value--;
                Counter.setText(String.valueOf(value));
            }
        });

        store = findViewById(R.id.button2);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://www.walmart.com/ip/Knox-Gear-Z-Style-Adjustable-Keyboard-Stand/49849471");

            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}

