package com.example.arbitragebot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.arbitragebot.CardSlider.FeaturedAdapter;
import com.example.arbitragebot.CardSlider.FeaturedHelperClass;

import java.util.ArrayList;

public class Bestone extends AppCompatActivity {
    RecyclerView BEST;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestone);

        BEST = findViewById(R.id.picked_recycle);

        pickedRecycler();
    }

    private void pickedRecycler() {
        BEST.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.asus, "ASUS Laptop", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bulb, "Bulb", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.gloves, "Gloves", "Amazon In stock"));

        featuredLocations.add(new FeaturedHelperClass(R.drawable.dicks, "Dick's Sporting Goods", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.pw50_carburetor, "Carburetor", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.xenon_headlights, "Xenon Headlights", "Amazon In stock"));

        adapter = new FeaturedAdapter(featuredLocations,getApplicationContext());
        BEST.setAdapter(adapter);
    }
}