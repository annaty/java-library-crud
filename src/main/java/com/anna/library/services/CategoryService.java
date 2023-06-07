package com.anna.library.services;

import com.anna.library.entities.Category;
import com.anna.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public boolean isRepositoryEmpty() {
        return categoryRepository.count() == 0;
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category newCategory(Category category) {
        return categoryRepository.save(category);
    }
}
