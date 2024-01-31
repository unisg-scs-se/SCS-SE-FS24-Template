package com.example.bookexample.service;

import com.example.bookexample.model.Book;
import com.example.bookexample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service // or @Service("BookService")
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository; // the underlying JPA repository

    ArrayList<Book> bookList = new ArrayList<>(); // this caches the database

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ArrayList<Book> findAllBooks() {

        ArrayList<Book> bookListRepo = (ArrayList<Book>) bookRepository.findAll();
        if (bookListRepo.isEmpty())
            return bookList;
        else
            return bookListRepo;
    }
    @Override
    public Book findBookById(long id) {return bookRepository.findById(id);}

    @Override
    public void addBook(Book b) {
        Book newBook = bookRepository.save(b);
        bookList.add(newBook);
    }
    @Override
    public void deleteAllBooks() {
        bookList.clear();
        bookRepository.deleteAll();
    }

    @Override
    public void deleteBookById(long id) {
        Book deleteBook = null;
        for (Book book : bookList) {
            if (book.getId() == id) {
                deleteBook = book;
            }
        }

        if (deleteBook != null) {
            bookList.remove(deleteBook);
            bookRepository.delete(deleteBook);

        }
    }

    @Override
    public void deleteBook(Book b) {
        deleteBookById(b.getId());
    }

    @Override
    public boolean updateBook(Book b) {
        for (Book book : bookList) {
            if (book.getId() == b.getId()) {
                book.setAuthor(b.getAuthor());
                book.setTitle(b.getTitle());
                bookRepository.save(book);
                return true;
            }
        }
        return false;
    }
}
