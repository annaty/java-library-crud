package com.anna.library.repositories;

import com.anna.library.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long > {
    @Query("SELECT b FROM Book b WHERE b.isLent = false AND b.isDeleted = false")
    Iterable<Book> getAllAvailableBooks();

    @Query("SELECT b FROM Book b INNER JOIN BookLending bl ON b.id = bl.bookId WHERE bl.returnDate IS NULL")
    Iterable<Book> getAllCurrentlyBorrowedBooks();
}
