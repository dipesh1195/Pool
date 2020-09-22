package com.example.jkhana.fastfood;

import java.util.ArrayList;

public class abd{
    static ArrayList<FoodData> cartlist = new ArrayList<>();

    public abd(ArrayList<FoodData> cartlist) {

        this.cartlist = cartlist;
    }

    static public ArrayList<FoodData> getlist()
    {
        return cartlist;

    }
}
