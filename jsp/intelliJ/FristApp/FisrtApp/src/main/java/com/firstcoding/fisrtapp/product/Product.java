package com.firstcoding.fisrtapp.product;

import java.util.Arrays;

public class Product {

    private String[] list = {"phantom", "Fanletter", "SuspectX", "Dracula"};

    private int price = 1000;

    public Product() {
    }

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "list=" + Arrays.toString(list) +
                ", price=" + price +
                '}';
    }

}
