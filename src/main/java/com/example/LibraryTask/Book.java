package com.example.LibraryTask;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document
public class Book {
    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
    private boolean published;
    private int quantity;
    private double price;

    @DBRef
    private Author author;

    public Book(String title, boolean published, int quantity, double price, Author author) {
        this.title = title;
        this.published = published;
        this.quantity = quantity;
        this.price = price;
        this.author = author;
    }

    // Added these two method to fix an issue of the .remove method used in PaymentController.java - removeFromBill
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;

        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
