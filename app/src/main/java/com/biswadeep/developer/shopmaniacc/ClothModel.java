package com.biswadeep.developer.shopmaniacc;

public class ClothModel {
    private String title;
    private String color;


    public ClothModel() {}

    public ClothModel(String title, String color) {
        this.title= title;
        this.color= color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
