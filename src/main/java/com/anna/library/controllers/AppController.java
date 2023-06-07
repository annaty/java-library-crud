package com.anna.library.controllers;

import com.anna.library.entities.Book;
import com.anna.library.services.AuthorService;
import com.anna.library.services.BookService;
import com.anna.library.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("authors", authorService.getAuthors());

        return "books";
    }

    @GetMapping("/books/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAuthors());
        model.addAttribute("categories", categoryService.getCategories());
        return "book_form";
    }

    @PostMapping("/books/save")
    public String saveBook(Book book) {
        bookService.newBook(book);
        return "redirect:/books";
    }
//
//    @PostMapping("/sapin/{treeId}/addDecoration/{decorationId}")
//    public boolean addDecoration(@PathVariable Long treeId, @PathVariable Long decorationId) {
//        return sapinService.addDecoration(treeId, decorationId);
//    }
//
//    @PostMapping("/sapin/vente/{id}")
//    public BonDeCommande sellTree(@PathVariable Long id) {
//        return sapinService.sellTree(id);
//    }
//
//    @GetMapping("/sapin/commande/get/{id}")
//    public BonDeCommande getOrder(@PathVariable Long id) {
//        return sapinService.getOrder(id);
//    }
}
