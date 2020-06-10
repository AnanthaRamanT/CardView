package com.example.cardview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;

import java.util.ArrayList;
import java.util.Arrays;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.MyViewHolder>
{

    Context context;
    ArrayList<String> list;


    String[] imageurl={"https://www.simplifiedcoding.net/demos/marvel/captainamerica.jpg",
                "https://www.simplifiedcoding.net/demos/marvel/ironman.jpg",
                "https://www.simplifiedcoding.net/demos/marvel/logan.jpg",
                "https://www.simplifiedcoding.net/demos/marvel/spiderman.jpg",
                "https://www.simplifiedcoding.net/demos/marvel/thor.jpg"};

    ArrayList<String> imagelist=new ArrayList(Arrays.asList(imageurl));

    public RowAdapter(Context context,ArrayList<String> list) {
        this.context = context;
        this.list=list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        CardView cardView;
        RecyclerView recycle1;
        LinearLayoutManager manager;
        ImageAdapter imageadapter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView=(itemView).findViewById(R.id.cardview);
            recycle1=(itemView).findViewById(R.id.recycle1);

            manager=new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recycle1.setLayoutManager(manager);
            imageadapter=new ImageAdapter(context,imagelist);
            recycle1.setAdapter(imageadapter);

        }
    }
}
