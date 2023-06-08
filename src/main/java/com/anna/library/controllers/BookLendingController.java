package com.anna.library.controllers;

import com.anna.library.entities.BookLending;
import com.anna.library.services.BookLendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.stream.StreamSupport;

@Controller
public class BookLendingController {

    @Autowired
    BookLendingService bookLendingService;

    @GetMapping("/lendings")
    public String getLendings(Model model) {
        model.addAttribute("bookLendings", bookLendingService.getBookLendings());
        model.addAttribute(
                "lendingsCount",
                StreamSupport.stream(bookLendingService.getBookLendings().spliterator(), false).count()
        );
        return "lendings/lendings";
    }

    @GetMapping("/lendings/search")
    public String searchLendingsWithinDateRange(
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate,
            Model model
    ) {
        model.addAttribute("bookLendings", bookLendingService.searchBookLendingsByDate(LocalDate.parse(startDate), LocalDate.parse(endDate)));
        model.addAttribute(
                "lendingsCount",
                StreamSupport.stream(
                        bookLendingService.searchBookLendingsByDate(LocalDate.parse(startDate), LocalDate.parse(endDate)).spliterator(),
                        false)
                        .count()
        );
        return "lendings/lendings";
    }

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
