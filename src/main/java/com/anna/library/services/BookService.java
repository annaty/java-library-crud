package com.anna.library.services;

import com.anna.library.entities.Book;
import com.anna.library.repositories.BookLendingRepository;
import com.anna.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookLendingRepository bookLendingRepository;

    public boolean isRepositoryEmpty() {
        return bookRepository.count() == 0;
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

//    public Iterable<Book> getBorrowedBooks(Long user) {
//    }
//
//    public Iterable<Book> getAvailableBooks() {
//    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
