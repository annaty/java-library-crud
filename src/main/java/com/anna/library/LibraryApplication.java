package com.anna.library;

import com.anna.library.entities.Author;
import com.anna.library.entities.Book;
import com.anna.library.entities.Category;
import com.anna.library.entities.Client;
import com.anna.library.services.AuthorService;
import com.anna.library.services.BookService;
import com.anna.library.services.CategoryService;
import com.anna.library.services.ClientService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryApplication {
	@Autowired
	private AuthorService authorService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BookService bookService;
	@Autowired
	private ClientService clientService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@PostConstruct
	public void init() {
		if (authorService.isRepositoryEmpty()) {
			authorService.newAuthor(new Author("Herman", "Melville"));
			authorService.newAuthor(new Author("Mark", "Twain"));
			authorService.newAuthor(new Author("William", "Shakespeare"));
			authorService.newAuthor(new Author("Emily", "Bronte"));
			authorService.newAuthor(new Author("Ernest", "Hemingway"));
		}
		if (categoryService.isRepositoryEmpty()) {
			categoryService.newCategory(new Category("Fiction"));
			categoryService.newCategory(new Category("Non-fiction"));
			categoryService.newCategory(new Category("Drama"));
			categoryService.newCategory(new Category("Poetry"));
			categoryService.newCategory(new Category("Romance"));
		}
		if (bookService.isRepositoryEmpty()) {
			bookService.newBook(new Book(
					"Moby Dick",
					LocalDate.of(1851, 10, 18),
					500, 1L, 1L));
			bookService.newBook(new Book(
					"The Adventures of Tom Sawyer",
					LocalDate.of(1876, 6, 9),
					300, 1L, 2L));
			bookService.newBook(new Book(
					"The Adventures of Huckleberry Finn",
					LocalDate.of(1884, 12, 10),
					300, 1L, 2L));
			bookService.newBook(new Book(
					"Macbeth",
					LocalDate.of(1611, 4, 20),
					50, 3L, 3L));
			bookService.newBook(new Book(
					"Wuthering Heights",
					LocalDate.of(1847, 12, 1),
					300, 1L, 4L));
			bookService.newBook(new Book(
					"For Whom the Bell Tolls",
					LocalDate.of(1940, 10, 1),
					300, 1L, 5L));
		}
		if (clientService.isRepositoryEmpty()) {
			clientService.newClient(new Client("Anna", "Tylkowska", "anna@test.com"));
			clientService.newClient(new Client("John", "Doe", "john@test.com"));
			clientService.newClient(new Client("Adam", "Smith", "adam@test.com"));
		}
	}

}
