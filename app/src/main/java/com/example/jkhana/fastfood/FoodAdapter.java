package com.example.jkhana.fastfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.bumptech.glide.Glide;
import com.example.jkhana.R;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends Adapter<FoodViewHolder> {
    private Context context;
    private List<FoodData> itemlist;

    public FoodAdapter(Context context, List<FoodData> itemList) {
        this.context = context;
        this.itemlist = itemList;
    }

    public FoodViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewType) {
        return new FoodViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.recycler_glocerie, viewgroup, false));
    }

    public void onBindViewHolder(FoodViewHolder holder, int i) {
        Glide.with(context).load(itemlist.get(i).getItemImage()).into(holder.image);
        holder.mtitle.setText(((FoodData) this.itemlist.get(i)).getItemName());
        holder.mdesc.setText(((FoodData) this.itemlist.get(i)).getItemDesc());
        holder.mprice.setText("Rs. "+Integer.toString(((FoodData) this.itemlist.get(i)).getItemPrice()));
        holder.mrestuname.setText(((FoodData)this.itemlist.get(i)).getRestuname());

    }

    public int getItemCount() {

        return this.itemlist.size();
    }
}
