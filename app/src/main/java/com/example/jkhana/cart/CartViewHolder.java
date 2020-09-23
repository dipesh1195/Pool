package com.example.jkhana.cart;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.jkhana.R;

import org.w3c.dom.Text;

public class CartViewHolder extends RecyclerView.ViewHolder {
    TextView title,price;
    ImageView itemimage,deletebtn;
    ElegantNumberButton btn;
    public int quantity;


    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.cart_name);
        price = itemView.findViewById(R.id.price);
        itemimage = itemView.findViewById(R.id.cart_img);
        deletebtn = itemView.findViewById(R.id.delete);
        btn = itemView.findViewById(R.id.number);
        btn.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                String quantity = btn.getNumber();
            }
        });



    }
}
