package com.example.bookexample.service;

import com.example.bookexample.model.Book;

import java.util.ArrayList;

public interface BookService {
    ArrayList<Book> findAllBooks();
    Book findBookById(long id);
    void addBook(Book b);
    boolean updateBook(Book b);
    void deleteBook(Book b);
    void deleteAllBooks();
    void deleteBookById(long id);

}
