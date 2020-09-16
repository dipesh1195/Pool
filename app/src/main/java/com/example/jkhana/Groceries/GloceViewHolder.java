package com.example.jkhana.Groceries;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.jkhana.R;

/* compiled from: GloceAdapter */
class GloceViewHolder extends ViewHolder {
    CardView card;
    ImageView image;
    TextView mdesc;
    TextView mprice;
    TextView mtitle;

    public GloceViewHolder(View itemView) {
        super(itemView);
        this.image = (ImageView) itemView.findViewById( R. id.gloImage);
        this.mtitle = (TextView) itemView.findViewById( R. id.title);
        this.mdesc = (TextView) itemView.findViewById( R. id.Desc);
        this.mprice = (TextView) itemView.findViewById( R. id.price);
        this.card = (CardView) itemView.findViewById( R. id.GrocerieCardView);
    }
}
