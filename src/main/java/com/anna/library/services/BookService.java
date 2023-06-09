package com.anna.library.services;

import com.anna.library.entities.Book;
import com.anna.library.repositories.BookLendingRepository;
import com.anna.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

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

    public Iterable<Book> getBorrowedBooks() {
        return bookRepository.getAllCurrentlyBorrowedBooks();
    }

    public Iterable<Book> getAvailableBooks() {
        return bookRepository.getAllAvailableBooks();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.findById(id).ifPresent(book -> {
            book.deleteBook();
            bookRepository.save(book);
        });
    }

    public Iterable<Book> searchBooksByAuthor(String query) {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .filter(book -> book.getAuthor().getFirstName().toLowerCase().contains(query.toLowerCase()) || book.getAuthor().getLastName().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }
}
