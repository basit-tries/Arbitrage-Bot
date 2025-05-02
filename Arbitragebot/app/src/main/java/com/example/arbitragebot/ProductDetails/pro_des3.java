package com.example.arbitragebot.ProductDetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arbitragebot.R;


public class pro_des3 extends AppCompatActivity {

    Button pc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_des3);

        pc = findViewById(R.id.pc);

        pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://www.newegg.com/midnight-black-asus-vivobook-s-14x-oled-s5402za-is74-home-personal/p/34-236-330?Item=34-236-330&cm_sp=homepage-_-newegglive-371-_-product-34-236-330");

            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}