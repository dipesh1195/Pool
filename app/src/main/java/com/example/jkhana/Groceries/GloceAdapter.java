package com.example.jkhana.Groceries;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.bumptech.glide.Glide;
import com.example.jkhana.R;
import com.example.jkhana.fastfood.FoodData;
import com.example.jkhana.fastfood.abd;

import java.util.ArrayList;
import java.util.List;

public class GloceAdapter extends Adapter<GloceViewHolder> {
    private Context context;
    public ArrayList<FoodData> itemlist;
    public static ArrayList<FoodData> cartlist = new ArrayList<FoodData>();;
    FoodData cart;

    public GloceAdapter(Context context, ArrayList<FoodData> itemList) {
        this.context = context;
        this.itemlist =  itemList;
    }

    public GloceViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewType) {
        return new GloceViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.recycler_glocerie, viewgroup, false));
    }

    public void onBindViewHolder(@NonNull final GloceViewHolder holder, final int i) {
        Glide.with(context).load(itemlist.get(i).getItemImage()).into(holder.image);
        holder.mtitle.setText(((FoodData) this.itemlist.get(i)).getItemName());
        holder.mdesc.setText(((FoodData) this.itemlist.get(i)).getItemDesc());
        holder.mprice.setText("Rs. " + Integer.toString(((FoodData) this.itemlist.get(i)).getItemPrice()));
        holder.mrestuname.setText(((FoodData) this.itemlist.get(i)).getRestuname());
        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart = new FoodData(itemlist.get(i).getItemName(), itemlist.get(i).getItemDesc(),itemlist.get(i).getItemPrice(), itemlist.get(i).getItemImage(), itemlist.get(i).getRestuname());
                cartlist.add(cart);
                new abd(cartlist);
                holder.addtocart.setText("Item added to cart");
                holder.addtocart.setTextColor(Color.WHITE);

            }
        });
    }
    public static ArrayList<FoodData> cartitem(){
        return cartlist;
    }

    public int getItemCount() {
        return itemlist.size();
    }
}
