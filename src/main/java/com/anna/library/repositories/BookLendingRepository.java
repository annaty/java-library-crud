package com.anna.library.repositories;

import com.anna.library.entities.BookLending;
import org.springframework.data.repository.CrudRepository;

public interface BookLendingRepository extends CrudRepository<BookLending,Long > {
}
