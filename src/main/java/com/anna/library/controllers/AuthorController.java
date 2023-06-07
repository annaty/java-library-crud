package com.anna.library.controllers;

import com.anna.library.entities.Author;
import com.anna.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @GetMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.getAuthors());
        return "authors/authors";
    }

    @GetMapping("/authors/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("pageTitle", "Add new author");

        return "authors/author_form";
    }

    @PostMapping("/authors/save")
    public String saveAuthor(Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/edit/{id}")
    public String editAuthor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("author", authorService.getAuthor(id));
        model.addAttribute("pageTitle", "Edit author");
        return "authors/author_form";
    }

    @GetMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id, Model model) {
        this.authorService.deleteAuthor(id);
        return "redirect:/authors";
    }
}
