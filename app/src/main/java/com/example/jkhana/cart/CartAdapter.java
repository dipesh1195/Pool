package com.example.jkhana.cart;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jkhana.R;
import com.example.jkhana.fastfood.FoodAdapter;
import com.example.jkhana.fastfood.FoodData;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    public ArrayList<FoodData> cartlist;
    FragmentActivity activity;
    public CartAdapter(FragmentActivity activity, ArrayList<FoodData> cartlist) {
        this.cartlist = cartlist;
        this.activity = activity;
    }



    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cart, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, final int i) {

        Glide.with(activity).load(cartlist.get(i).getItemImage()).into(holder.itemimage);
        holder.title.setText(( cartlist.get(i)).getItemName());
        holder.price.setText("Rs. "+Integer.toString((cartlist.get(i)).getItemPrice()));

        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cartlist.isEmpty()){
                    Toast.makeText(activity, "Nothing to remove", Toast.LENGTH_SHORT).show();
                }else
                cartlist.remove(i);
                new CartAdapter(activity,cartlist).notifyDataSetChanged();


            }
        });

    }

    @Override
    public int getItemCount() {
        return cartlist.size();
    }
}

