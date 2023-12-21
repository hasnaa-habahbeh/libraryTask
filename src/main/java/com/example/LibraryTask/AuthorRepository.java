package com.example.LibraryTask;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Author findByName(String name);
}
