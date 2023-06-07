package com.anna.library.controllers;

import com.anna.library.entities.BookLending;
import com.anna.library.services.BookLendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookLendingController {

    @Autowired
    BookLendingService bookLendingService;
    @GetMapping("/client/lend/{bookId}")
    public String lendBook(@PathVariable("bookId") Long bookId) {
        bookLendingService.lendBook(new BookLending(bookId));
        return "redirect:/client";
    }

    @GetMapping("client/return/{lendingId}")
    public String returnBook(@PathVariable("lendingId") Long lendingId) {
        bookLendingService.returnBook(lendingId);
        return "redirect:/client";
    }
}
