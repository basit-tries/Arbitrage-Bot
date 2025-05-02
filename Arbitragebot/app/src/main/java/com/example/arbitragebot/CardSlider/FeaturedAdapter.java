package com.example.arbitragebot.CardSlider;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.arbitragebot.ProductDetails.ProductDes;
import com.example.arbitragebot.R;
import com.example.arbitragebot.Registeration.Details;
import com.example.arbitragebot.Registeration.ForgetPassword;
import com.example.arbitragebot.Registeration.Login;
import com.example.arbitragebot.Registeration.Profile;
import com.example.arbitragebot.model.Productdetails;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter <FeaturedAdapter.FeaturedViewHolder>{


    Context context;
    ArrayList<FeaturedHelperClass>featuredLocations;





    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations, Context context) {
        this.context = context;
        this.featuredLocations = featuredLocations;}

         public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

             ImageView image;
             TextView title,description;


            public FeaturedViewHolder(@NonNull View itemView) {
                super(itemView);


                //Hooks
                image = itemView.findViewById(R.id.featuredimage);
                title = itemView.findViewById(R.id.featuredtitle);
                description = itemView.findViewById(R.id.featureddesc);

            }
        }







    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
    FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
    return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

    FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);

    holder.image.setImageResource(featuredHelperClass.getImage());
    holder.title.setText(featuredHelperClass.getTitle());
    holder.description.setText(featuredHelperClass.getDescription());

    holder.image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, Details.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    });

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();

    }
}
