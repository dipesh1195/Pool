package com.example.jkhana.Groceries;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.jkhana.R;

/* compiled from: GloceAdapter */
class GloceViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView mdesc;
    Button addtocart;
    TextView mprice;
    TextView mtitle;
    TextView mrestuname,total,price;
    Button checkout;


    public GloceViewHolder(@NonNull View itemView) {
        super(itemView);

        this.image = (ImageView) itemView.findViewById(R.id.gloImage);
        this.mtitle = (TextView) itemView.findViewById(R.id.title);
        this.mdesc = (TextView) itemView.findViewById(R.id.Desc);
        this.mprice = (TextView) itemView.findViewById(R.id.price);
        this.mrestuname = itemView.findViewById(R.id.restu);
        this.addtocart = itemView.findViewById(R.id.cart);
        this.total = itemView.findViewById(R.id.total);
        this.price = itemView.findViewById(R.id.price);
        this.checkout = itemView.findViewById(R.id.checkout);
    }
}