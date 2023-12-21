package com.example.LibraryTask;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Bill {
    @Id
    private String id;
    private double totalPrice;
    @DBRef
    private List<Book> books;

    public Bill(double totalPrice, List<Book> books) {
        this.totalPrice = totalPrice;
        this.books = books;
    }
}
