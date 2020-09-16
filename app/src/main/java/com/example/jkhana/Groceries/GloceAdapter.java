package com.example.jkhana.Groceries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.jkhana.R;

import java.util.ArrayList;
import java.util.List;

public class GloceAdapter extends Adapter<GloceViewHolder> {
    private List<GroceriesData> glocerieList = new ArrayList();
    private Context mcontext;

    public GloceAdapter(Context mcontext2, List<GroceriesData> glocerieList1) {
        this.mcontext = mcontext2;
        this.glocerieList = glocerieList1;
    }

    public GloceViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewType) {
        return new GloceViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.recycler_glocerie, viewgroup, false));
    }

    public void onBindViewHolder(GloceViewHolder holder, int i) {
        holder.image.setImageResource(((GroceriesData) this.glocerieList.get(i)).getItemImage());
        holder.mtitle.setText(((GroceriesData) this.glocerieList.get(i)).getItemName());
        holder.mdesc.setText(((GroceriesData) this.glocerieList.get(i)).getItemDesc());
        holder.mprice.setText(((GroceriesData) this.glocerieList.get(i)).getItemPrice());
    }

    public int getItemCount() {
        return this.glocerieList.size();
    }
}
