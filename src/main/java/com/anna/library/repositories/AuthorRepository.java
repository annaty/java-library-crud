package com.anna.library.repositories;

import com.anna.library.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long > {
}
