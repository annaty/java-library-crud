package com.anna.library.services;

import com.anna.library.entities.Author;
import com.anna.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public boolean isRepositoryEmpty() {
        return authorRepository.count() == 0;
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
