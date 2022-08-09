package com.example.sfeir.restreactive.restAPI.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collation = "books")
public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private int price;
    private boolean isPublished;

    public Book(){}
    public Book(String title, String author, int price, boolean isPublished){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isPublished = isPublished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPublished(){
        return isPublished;
    }

    public void setPublished(boolean published){
        this.isPublished = published;
    }
}
