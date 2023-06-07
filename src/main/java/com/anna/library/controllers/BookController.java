package com.anna.library.controllers;

import com.anna.library.entities.Book;
import com.anna.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/get/books")
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
    }
}
