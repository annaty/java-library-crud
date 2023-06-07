package com.anna.library.controllers;

import com.anna.library.entities.Category;
import com.anna.library.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @GetMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "categories/categories";
    }

    @GetMapping("/categories/new")
    public String newCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("pageTitle", "Add new category");

        return "categories/category_form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", categoryService.getCategory(id));
        model.addAttribute("pageTitle", "Edit category");
        return "categories/category_form";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model) {
        this.categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
