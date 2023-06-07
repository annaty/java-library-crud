package com.anna.library.services;

import com.anna.library.entities.BookLending;
import com.anna.library.repositories.BookLendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLendingService {
    @Autowired
    BookLendingRepository bookLendingRepository;

    public boolean isRepositoryEmpty() {
        return bookLendingRepository.count() == 0;
    }

    public BookLending getBookLending(Long id) {
        return bookLendingRepository.findById(id).orElse(null);
    }

    public Iterable<BookLending> getBookLendings() {
        return bookLendingRepository.findAll();
    }

//    public Iterable<Book> getAllBorrowedBooks() {
//        JOIN book ON book_lending where book_lending.book_id = book.id
//         WHERE book_lending.return_date IS NULL
//    }

//    public Iterable<Book> getAllAvailableBooks() {
//        JOIN books ON book_lending where book_lending.book_id = book.id WHERE book_lending.book_id IS NULL
//    }

//    public Iterable<Book> getBorrowedBooksOfUser(Long userId) {
//         JOIN book_lending.user_id = userId
//         JOIN book ON book_lending.book_id = book.id
//         WHERE book_lending.return_date IS NULL
//    }

    public BookLending lendBook(BookLending bookLending) {
        return bookLendingRepository.save(bookLending);
    }

    public boolean returnBook(Long bookLendingId) {
        return bookLendingRepository.findById(bookLendingId).map(bookLending -> {
            bookLending.setReturnDate();
            bookLendingRepository.save(bookLending);
            return true;
        }).orElse(false);
    }
}
