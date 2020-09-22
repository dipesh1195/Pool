package com.example.jkhana.dinner;

public class DinnerData {
    private String itemDesc;
    private String itemImage;
    private String itemName;
    private int itemPrice;
    private String restuname;


    public DinnerData(String itemName, String itemDesc, int itemPrice, String itemImage, String restuname) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.restuname = restuname;
    }

    public String getItemName() {

        return this.itemName;
    }

    public String getItemDesc() {

        return this.itemDesc;
    }

    public int getItemPrice() {

        return this.itemPrice;
    }

    public String getItemImage() {

        return this.itemImage;
    }

    public String getRestuname() {
        return this.restuname;
    }
}


