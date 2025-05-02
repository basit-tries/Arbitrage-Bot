package com.example.arbitragebot.ProductDetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arbitragebot.R;


public class pro_des6 extends AppCompatActivity {


    Button sock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_des6);

        sock = findViewById(R.id.sock);

        sock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://www.sears.com/jobsite-6-pairs-men-s-working-cushioned-crew/p-A106466320");

            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}