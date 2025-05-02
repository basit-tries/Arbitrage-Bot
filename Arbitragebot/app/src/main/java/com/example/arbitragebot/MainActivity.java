package com.example.arbitragebot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arbitragebot.CardSlider.CardSliderAdapter;
import com.example.arbitragebot.CardSlider.FeaturedAdapter;
import com.example.arbitragebot.CardSlider.FeaturedHelperClass;
import com.example.arbitragebot.Registeration.Profile;
import com.example.arbitragebot.Registeration.Settings;
import com.example.arbitragebot.adapter.ProductCategoryAdapter;
import com.example.arbitragebot.model.ProductCategory;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    FirebaseDatabase database;
    DatabaseReference Ref;
    ImageButton imageButton;
    EditText edtfirst, edtlast;

    Button btnnsert;

    static final float END_SCALE = 0.7f;

    LinearLayout contentView;
    //categories

    // Button allbtn;


    RecyclerView R1, R2, R3;
    RecyclerView.Adapter adapter;
    RecyclerView productCatRecycler;
    ProductCategoryAdapter productCategoryAdapter;

    //drawer menu/settings
    ImageView seticon, profiles, prback, trending, bestOnes, top , bestSeller;

    //DrawerLayout drawerlayout;
    //NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        seticon = findViewById(R.id.set);
        seticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Settings.class);

                startActivity(intent);
            }
        });

        //profile opening button
        profiles = findViewById(R.id.profile);

        profiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);

            }
        });

        //Categories Listener

        trending = findViewById(R.id.trending);
        trending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Trending.class);
                startActivity(intent);
            }
        });

        top = findViewById(R.id.top);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TOP.class);
                startActivity(intent);
            }
        });

        bestOnes = findViewById(R.id.bestone);
        bestOnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Bestone.class);
                startActivity(intent);
            }
        });

        bestSeller = findViewById(R.id.bestseller);
        bestSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Bestseller.class);
                startActivity(intent);
            }
        });




//Recyclers
        R1 = findViewById(R.id.search_recycle);
        R2 = findViewById(R.id.mv_recycle);
        R3 = findViewById(R.id.ctg_recycle);


        featuredRecycler();
        secondRecycler();
        thirdrecycler();

        //drawers menu/settings


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    private void featuredRecycler() {
        //fixed size for the ones that are visible on the screen
        R1.setHasFixedSize(false);
        R1.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.keybstand3, "Keyboard Stand", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.turtleneck, "Turtleneck", "Walmart In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.game, "Pack of Games", "Dick's In stock"));

        featuredLocations.add(new FeaturedHelperClass(R.drawable.ic_keystand3, "Keyboard Mount", "Target In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mugs, "Mugs", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.shoes, "Shoes", "Amazon In stock"));


        adapter = new FeaturedAdapter(featuredLocations,getApplicationContext());
        R1.setAdapter(adapter);


    }

    private void secondRecycler() {
        //fixed size for the ones that are visible on the screen
        R2.setHasFixedSize(false);
        R2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.sneaker, "Sneakers", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.sink, "Sink", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.socks, "Socks", "Amazon In stock"));

        featuredLocations.add(new FeaturedHelperClass(R.drawable.strips, "Strips", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.vacum, "Vacuum", "Amazon In stock"));


        adapter = new FeaturedAdapter(featuredLocations,getApplicationContext());
        R2.setAdapter(adapter);


    }

    private void thirdrecycler() {
        //fixed size for the ones that are visible on the screen
        R3.setHasFixedSize(false);
        R3.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.asus, "ASUS Laptop", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bulb, "Bulb", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.gloves, "Gloves", "Amazon In stock"));

        featuredLocations.add(new FeaturedHelperClass(R.drawable.dicks, "Dick's Sporting Goods", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.pw50_carburetor, "Carburetor", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.xenon_headlights, "Xenon Headlights", "Amazon In stock"));

        adapter = new FeaturedAdapter(featuredLocations,getApplicationContext());
        R3.setAdapter(adapter);


    }

}
