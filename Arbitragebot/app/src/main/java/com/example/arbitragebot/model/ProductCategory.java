package com.example.arbitragebot.model;

public class ProductCategory {

    int image;
    String productName,ID;

    public ProductCategory(int image, String productName,String ID) {
        this.image = image;
        this.ID = ID;
        this.productName = productName;
    }

    public int getImage() {
        return image;
    }

    public String getID(){return ID;}

    public String getProductName() {
        return productName;
    }


}
