package com.anna.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
    String title;
    @Column(name = "publication_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate publicationDate;
    @Column(name = "page_count", nullable = false)
    Integer pageCount;
    @Column(name = "category_id", nullable = false)
    Long categoryId;
    @Column(name = "author_id", nullable = false)
    Long authorId;
    @Column(name = "is_lent", nullable = false)
    boolean isLent;
    @Column(name = "is_deleted", nullable = false)
    boolean isDeleted;

    @OneToMany(mappedBy = "book")
    private Collection<BookLending> bookLendings;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    public Book (String title, LocalDate publicationDate, Integer numberOfPages, Long categoryId, Long authorId) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.pageCount = numberOfPages;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.isLent = false;
    }

    public Book() {
    }

    public void lendBook() {
        this.isLent = true;
    }

    public void returnBook() {
        this.isLent = false;
    }

    public void deleteBook() {
        this.isDeleted = true;
    }

    public Integer getLendingsCount() {
        return this.bookLendings.size();
    }
}
