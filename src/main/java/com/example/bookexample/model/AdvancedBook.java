package com.example.bookexample.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//This is just to illustrate the use of Project Lombok
public class AdvancedBook {

    private long id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String isbn;
    private double price;
    private int noOfPages;
    private String editor;
    private double discountedprice;


}
