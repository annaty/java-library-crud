package com.anna.library.controllers;

import com.anna.library.entities.Book;
import com.anna.library.services.AuthorService;
import com.anna.library.services.BookService;
import com.anna.library.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("authors", authorService.getAuthors());

        return "books/books";
    }

    @GetMapping("/books/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAuthors());
        model.addAttribute("categories", categoryService.getAvailableCategories());
        model.addAttribute("pageTitle", "Add new book");
        return "books/book_form";
    }

    @PostMapping("/books/save")
    public String saveBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {

        model.addAttribute("book", bookService.getBook(id));
        model.addAttribute("authors", authorService.getAuthors());
        model.addAttribute("categories", categoryService.getAvailableCategories());
        model.addAttribute("pageTitle", "Edit book");
        return "books/book_form";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/books/search{query}")
    public String searchBooksByAuthor(@RequestParam(value = "query") String query, Model model) {
        model.addAttribute("books", bookService.searchBooksByAuthor(query));
        model.addAttribute("authors", authorService.getAuthors());
        return "books/books";
    }
}
