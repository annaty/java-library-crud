package com.anna.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "book_lending")
public class BookLending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "book_lending_date", nullable = false)
    LocalDate bookLendingDate;
    @Column(name = "estimated_return_date", nullable = false)
    LocalDate estimatedReturnDate;
    @Column(name = "return_date", nullable = false)
    LocalDate returnDate;
    @Column(name = "book_id", nullable = false)
    Long bookId;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    public BookLending (LocalDate bookLendingDate, LocalDate estimatedReturnDate, LocalDate returnDate, Long clientId, Long bookId) {
        this.bookLendingDate = bookLendingDate;
        this.estimatedReturnDate = estimatedReturnDate;
        this.returnDate = returnDate;
        this.bookId = bookId;
    }

    public BookLending (Long bookId) {
        this.bookLendingDate = LocalDate.now();
        this.estimatedReturnDate = LocalDate.now().plusDays(30);
        this.returnDate = null;
        this.bookId = bookId;
    }

    public BookLending () {
        this.bookLendingDate = LocalDate.now();
        this.estimatedReturnDate = LocalDate.now().plusDays(30);
        this.returnDate = null;
        this.bookId = null;
    }

    public void setReturnDate() {
        this.returnDate = LocalDate.now();
    }
}
