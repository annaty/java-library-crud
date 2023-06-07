package com.anna.library.repositories;

import com.anna.library.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long > {
}
