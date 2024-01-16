package com.example.bookexample.controller;

import com.example.bookexample.model.Book;
import com.example.bookexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/findall", produces = "application/json")
    public ArrayList<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping(value = "/findbyid/{id}", produces = "application/json")
    public Book getBookById(@PathVariable long id) {
        return bookService.findBookById(id);
    }

    @PutMapping(value = "/updatebook/{id}", consumes = "application/json")
    public ResponseEntity updateBook(@PathVariable long id, @RequestBody Book book) {
        book.injectId(id);
        if (bookService.updateBook(book)) return new ResponseEntity<>(HttpStatus.OK);
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // if no book is found with the provided id
        }
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity deleteAllBooks() {
        bookService.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/deletebyid/{id}")
    public ResponseEntity deleteBookByNumber(@PathVariable long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
