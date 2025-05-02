package com.example.arbitragebot.ProductDetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arbitragebot.R;


public class ProductDes extends AppCompatActivity {

    Button store;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

    store = findViewById(R.id.Store);

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