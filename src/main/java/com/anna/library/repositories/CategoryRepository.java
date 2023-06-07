package com.anna.library.repositories;

import com.anna.library.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long > {
}
