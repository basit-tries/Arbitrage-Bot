package com.example.arbitragebot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.arbitragebot.CardSlider.FeaturedAdapter;
import com.example.arbitragebot.CardSlider.FeaturedHelperClass;

import java.util.ArrayList;

public class Trending extends AppCompatActivity {

    RecyclerView trend;
    RecyclerView.Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

        trend = findViewById(R.id.trending_recycle);

        trendingRecycler();


    }


    private void trendingRecycler() {

        trend.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.keybstand3, "Keyboard Stand", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.turtleneck, "Turtleneck", "Walmart In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.game, "Pack of Games", "Dick's In stock"));

        featuredLocations.add(new FeaturedHelperClass(R.drawable.ic_keystand3, "Keyboard Mount", "Target In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mugs, "Mugs", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.shoes, "Shoes", "Amazon In stock"));


        adapter = new FeaturedAdapter(featuredLocations,getApplicationContext());
        trend.setAdapter(adapter);

    }
}