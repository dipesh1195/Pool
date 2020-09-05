package com.example.jkhana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends Adapter<FoodViewHolder> {
    private List<FoodData> Foodlist = new ArrayList();
    private Context mcontext;

    public FoodAdapter(Context mcontext2, List<FoodData> Foodlist1) {
        this.mcontext = mcontext2;
        this.Foodlist = Foodlist1;
    }

    public FoodViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewType) {
        return new FoodViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.recycler_glocerie, viewgroup, false));
    }

    public void onBindViewHolder(FoodViewHolder holder, int i) {
        holder.image.setImageResource(((FoodData) this.Foodlist.get(i)).getItemImage());
        holder.mtitle.setText(((FoodData) this.Foodlist.get(i)).getItemName());
        holder.mdesc.setText(((FoodData) this.Foodlist.get(i)).getItemDesc());
        holder.mprice.setText(((FoodData) this.Foodlist.get(i)).getItemPrice());
    }

    public int getItemCount() {
        return this.Foodlist.size();
    }
}
