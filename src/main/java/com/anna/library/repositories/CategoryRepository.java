package com.anna.library.repositories;

import com.anna.library.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long > {
    @Query("SELECT c FROM Category c WHERE c.isDeleted = false")
    Iterable<Category> getAllAvailableCategories();
}
