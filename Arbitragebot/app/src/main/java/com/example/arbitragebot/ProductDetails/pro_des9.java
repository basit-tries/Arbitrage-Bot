package com.example.arbitragebot.ProductDetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arbitragebot.R;


public class pro_des9 extends AppCompatActivity {

    Button vac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_des9);

        vac = findViewById(R.id.vac);

        vac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://www.walmart.com/ip/KOBLENZ-SANITIZER-KIT-WET-DRY-BLOW-VAC-3-Gallon-2-Peak-HP-with-Virus-Disinfectant-Kit-2021-GOLD-INNOVATION-AWARD-RECIPIENT-WD-390k2/359837669?fulfillmentIntent=Shipping");

            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}