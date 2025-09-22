package com.example.BookReadingAppV3.service;

import com.example.BookReadingAppV3.model.Book;
import com.example.BookReadingAppV3.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository books;

    public Book saveBook(Book book){
        return books.save(book);
    }
    public Iterable<Book> getAll(){
        return books.findAll();
    }
    public Optional<Book> findBookByID(Long id){
        return books.findById(id);
    }
    public void deleteById(Long id){
        books.deleteById(id);
    }
    public Optional<Book> findByTitle(String title){
        return books.findByTitle(title);
    }
}
