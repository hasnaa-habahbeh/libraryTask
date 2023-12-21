package com.example.LibraryTask;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByAuthorName(String authorName);
    List<Book> findByPublished(boolean published);
    Book findByTitle(String name);
}
