package com.anna.library.controllers;

import com.anna.library.services.BookLendingService;
import com.anna.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {

    @Autowired
    BookService bookService;

    @Autowired
    BookLendingService bookLendingService;

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/librarian")
    public String showLibrarianPage() {
        return "home/librarian";
    }

    @GetMapping("/client")
    public String showClientPage(Model model) {
        model.addAttribute("currentLendings", bookLendingService.getCurrentBookLendings());
        model.addAttribute("availableBooks", bookService.getAvailableBooks());
        model.addAttribute("pastLendings", bookLendingService.getPastBookLendings());

        return "home/client";
    }
}
