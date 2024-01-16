package com.example.bookexample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;

    private String author;
    private String title;


    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book() {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String name) {
        this.author = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public long getId() { return id;}

    public void injectId(long id) { this.id = id;}
    // not providing the public Setter with the expected name setId renders fields in the generated GridCrud uneditable
    // Alternative: use setId() and omit the Id from the Crud forms
}
