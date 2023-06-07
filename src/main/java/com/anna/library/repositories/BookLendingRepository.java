package com.anna.library.repositories;

import com.anna.library.entities.BookLending;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookLendingRepository extends CrudRepository<BookLending,Long > {
    @Query("SELECT bl FROM BookLending bl WHERE bl.returnDate IS NULL")
    Iterable<BookLending> getAllCurrentLendings();

    @Query("SELECT bl FROM BookLending bl WHERE bl.returnDate IS NOT NULL")
    Iterable<BookLending> getAllPastLendings();
}
