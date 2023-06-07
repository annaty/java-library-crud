package com.anna.library.services;

import com.anna.library.entities.Book;
import com.anna.library.entities.BookLending;
import com.anna.library.repositories.BookLendingRepository;
import com.anna.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLendingService {
    @Autowired
    BookLendingRepository bookLendingRepository;

    @Autowired
    BookRepository bookRepository;

    public boolean isRepositoryEmpty() {
        return bookLendingRepository.count() == 0;
    }

    public BookLending getBookLending(Long id) {
        return bookLendingRepository.findById(id).orElse(null);
    }

    public Iterable<BookLending> getBookLendings() {
        return bookLendingRepository.findAll();
    }

    public Iterable<BookLending> getCurrentBookLendings() {
        return bookLendingRepository.getAllCurrentLendings();
    }

    public Iterable<BookLending> getPastBookLendings() {
        return bookLendingRepository.getAllPastLendings();
    }

    public BookLending lendBook(BookLending bookLending) {
        bookRepository.findById(bookLending.getBookId()).ifPresent(Book::lendBook);
        return bookLendingRepository.save(bookLending);
    }

    public boolean returnBook(Long bookLendingId) {
        return bookLendingRepository.findById(bookLendingId).map(bookLending -> {
            bookRepository.findById(bookLending.getBookId()).ifPresent(Book::returnBook);
            bookLending.setReturnDate();
            bookLendingRepository.save(bookLending);
            return true;
        }).orElse(false);
    }
}
