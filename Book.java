package com.example.dn.library_management_zxy;

/**
 * Created by DN on 2020/6/16.
 */

public class Book {
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private String press;

    public String getPress() {
        return press;
    }
    public void setPress(String press) {
        this.press = press;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}