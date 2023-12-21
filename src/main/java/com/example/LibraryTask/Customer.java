package com.example.LibraryTask;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {
    @Id
    private String id;
    private String name;
    @DBRef
    private Bill bill;

    public Customer(String name, Bill bill) {
        this.name = name;
        this.bill = bill;
    }
}
