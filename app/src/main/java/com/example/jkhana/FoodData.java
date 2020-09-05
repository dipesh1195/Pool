package com.example.jkhana;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodData {
    private String itemDesc;
    private int itemImage;
    private String itemName;
    private String itemPrice;


    public FoodData(String itemName2, String itemDesc2, String itemPrice2, int itemImage2) {
        this.itemName = itemName2;
        this.itemDesc = itemDesc2;
        this.itemPrice = itemPrice2;
        this.itemImage = itemImage2;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public String getItemPrice() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rs ");
        sb.append(this.itemPrice);
        return sb.toString();
    }

    public int getItemImage() {
        return this.itemImage;
    }
}
