package com.example.LibraryTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping("/all")
    public List<Book> fetchBooks(@RequestParam(required = false, defaultValue = "false") boolean includeUnPublished) {
        return booksService.getBooks(includeUnPublished);
    }

    @GetMapping("/byAuthor")
    public List<Book> fetchBooksByAuthor(@RequestParam String author) {
        return booksService.getBooksByAuthor(author);
    }
}
