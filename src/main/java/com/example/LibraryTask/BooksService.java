package com.example.LibraryTask;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BooksService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(boolean includeUnPublished) {
        if (includeUnPublished) {
            return bookRepository.findAll();
        } else {
            return bookRepository.findByPublished(true);
        }
    }

    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }
}
