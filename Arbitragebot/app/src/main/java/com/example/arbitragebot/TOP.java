package com.example.arbitragebot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.arbitragebot.CardSlider.FeaturedAdapter;
import com.example.arbitragebot.CardSlider.FeaturedHelperClass;

import java.util.ArrayList;

public class TOP extends AppCompatActivity {
    RecyclerView ToP;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        ToP = findViewById(R.id.top_recycle);

        topRecycler();
    }

    private void topRecycler() {
        ToP.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.sneaker, "Sneakers", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.sink, "Sink", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.socks, "Socks", "Amazon In stock"));

        featuredLocations.add(new FeaturedHelperClass(R.drawable.strips, "Strips", "Amazon In stock"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.vacum, "Vacuum", "Amazon In stock"));


        adapter = new FeaturedAdapter(featuredLocations,getApplicationContext());
        ToP.setAdapter(adapter);

    }
}