package com.example.jkhana.dinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jkhana.R;
import com.example.jkhana.fastfood.FoodData;

import java.util.ArrayList;

public class DinnerAdapter extends RecyclerView.Adapter {
    private Context context;
    public ArrayList<FoodData> itemlist;
    public ArrayList<FoodData> cartlist;
    DinnerData cart;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DinnerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_glocerie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }
}
