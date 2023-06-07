package com.anna.library.controllers;

import com.anna.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/librarian")
    public String showLibrarianPage() {
        return "home/librarian";
    }

    @GetMapping("/client")
    public String showClientPage() {
        return "home/client";
    }
}
