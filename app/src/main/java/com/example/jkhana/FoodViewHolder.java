package com.example.jkhana;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;


class FoodViewHolder extends ViewHolder {
    CardView card;
    ImageView image;
    TextView mdesc;
    TextView mprice;
    TextView mtitle;

    public FoodViewHolder(View itemView) {
        super(itemView);
        this.image = (ImageView) itemView.findViewById( R. id.gloImage);
        this.mtitle = (TextView) itemView.findViewById( R. id.title);
        this.mdesc = (TextView) itemView.findViewById( R. id.Desc);
        this.mprice = (TextView) itemView.findViewById( R. id.price);
        this.card = (CardView) itemView.findViewById( R. id.GrocerieCardView);
    }
}
