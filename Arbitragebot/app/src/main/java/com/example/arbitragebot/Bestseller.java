package com.example.arbitragebot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.arbitragebot.CardSlider.FeaturedAdapter;
import com.example.arbitragebot.CardSlider.FeaturedHelperClass;

import java.util.ArrayList;

public class Bestseller extends AppCompatActivity {
    RecyclerView Seller;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestseller);

        Seller = findViewById(R.id.seller_recycle);

        sellerRecycler();
    }

    private void sellerRecycler() {
        Seller.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.ikea, "IKEA", "Stuff about home"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.costco, "COSTCO", "Costco Retail Store"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.biglots, "BIG LOT'S", "Low Price Retail"));

        featuredLocations.add(new FeaturedHelperClass(R.drawable.target, "TARGET", "Target D.Store"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.homedepot, "HOME DEPOT", "Home Furnishing"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.dicksstore, "DICK'S", "Dick's Sporting Goods"));


        adapter = new FeaturedAdapter(featuredLocations,getApplicationContext());
        Seller.setAdapter(adapter);

    }
}