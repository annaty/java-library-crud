package com.anna.library;

import com.anna.library.entities.Author;
import com.anna.library.entities.Book;
import com.anna.library.entities.BookLending;
import com.anna.library.entities.Category;
import com.anna.library.repositories.BookLendingRepository;
import com.anna.library.services.AuthorService;
import com.anna.library.services.BookLendingService;
import com.anna.library.services.BookService;
import com.anna.library.services.CategoryService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

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
	private BookLendingService bookLendingService;
	@Autowired
	private BookLendingRepository bookLendingRepository;

	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@PostConstruct
	public void init() {
		if (authorService.isRepositoryEmpty()) {
			authorService.saveAuthor(new Author("Herman", "Melville"));
			authorService.saveAuthor(new Author("Mark", "Twain"));
			authorService.saveAuthor(new Author("William", "Shakespeare"));
			authorService.saveAuthor(new Author("Emily", "Bronte"));
			authorService.saveAuthor(new Author("Ernest", "Hemingway"));
		}
		if (categoryService.isRepositoryEmpty()) {
			categoryService.saveCategory(new Category("Fiction"));
			categoryService.saveCategory(new Category("Non-fiction"));
			categoryService.saveCategory(new Category("Drama"));
			categoryService.saveCategory(new Category("Poetry"));
			categoryService.saveCategory(new Category("Romance"));
		}
		if (bookService.isRepositoryEmpty()) {
			bookService.saveBook(new Book(
					"Moby Dick",
					LocalDate.of(1851, 10, 18),
					500, 1L, 1L));
			bookService.saveBook(new Book(
					"The Adventures of Tom Sawyer",
					LocalDate.of(1876, 6, 9),
					300, 1L, 2L));
			bookService.saveBook(new Book(
					"The Adventures of Huckleberry Finn",
					LocalDate.of(1884, 12, 10),
					300, 1L, 2L));
			bookService.saveBook(new Book(
					"Macbeth",
					LocalDate.of(1611, 4, 20),
					50, 3L, 3L));
			bookService.saveBook(new Book(
					"Wuthering Heights",
					LocalDate.of(1847, 12, 1),
					300, 1L, 4L));
			bookService.saveBook(new Book(
					"For Whom the Bell Tolls",
					LocalDate.of(1940, 10, 1),
					300, 1L, 5L));
		}
		if (bookLendingService.isRepositoryEmpty()) {
			bookLendingService.lendBook(new BookLending(
					LocalDate.parse("2023-03-01"),
					LocalDate.parse("2023-04-01"),
					LocalDate.parse("2023-03-23"),
					1L
			));
			bookLendingService.lendBook(new BookLending(
					LocalDate.parse("2023-04-01"),
					LocalDate.parse("2023-05-01"),
					LocalDate.parse("2023-04-23"),
					3L
			));
			bookLendingService.lendBook(new BookLending(
					LocalDate.parse("2023-04-10"),
					LocalDate.parse("2023-05-10"),
					LocalDate.parse("2023-04-30"),
					2L
			));
		}
	}

}
