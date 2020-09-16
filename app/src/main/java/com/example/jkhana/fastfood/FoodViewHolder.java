package com.example.jkhana.fastfood;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.jkhana.R;


class FoodViewHolder extends RecyclerView.ViewHolder {
    CardView card;
    ImageView image;
    TextView mdesc;
    TextView mprice;
    TextView mtitle;
    TextView mrestuname;

    public FoodViewHolder(View itemView) {
        super(itemView);
        this.image = (ImageView) itemView.findViewById( R. id.gloImage);
        this.mtitle = (TextView) itemView.findViewById( R. id.title);
        this.mdesc = (TextView) itemView.findViewById( R. id.Desc);
        this.mprice = (TextView) itemView.findViewById( R. id.price);
        this.card = (CardView) itemView.findViewById( R. id.GrocerieCardView);
        this.mrestuname = itemView.findViewById(R.id.restu);
    }
}
