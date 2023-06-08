package com.anna.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "is_deleted", nullable = false)
    boolean isDeleted;

    @OneToMany(mappedBy = "category")
    private Collection<Book> books;

    public Category (String name) {
        this.name = name;
        this.isDeleted = false;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public Category() {
    }

    public void deleteCategory() {
        this.isDeleted = true;
    }
}
